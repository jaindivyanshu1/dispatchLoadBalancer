package com.example.dispatchLoadBalancer.service.impl;

import com.example.dispatchLoadBalancer.dto.DispatchPlanDTO;
import com.example.dispatchLoadBalancer.dto.OrderDTO;
import com.example.dispatchLoadBalancer.model.Order;
import com.example.dispatchLoadBalancer.model.Vehicle;
import com.example.dispatchLoadBalancer.repository.OrderRepository;
import com.example.dispatchLoadBalancer.repository.VehicleRepository;
import com.example.dispatchLoadBalancer.service.DispatchService;
import com.example.dispatchLoadBalancer.util.DistanceCalculationAlgo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DispatchServiceImpl implements DispatchService {
    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<DispatchPlanDTO> generateDispatchPlan() {

        List<Vehicle> vehicles = vehicleRepository.findAll();

        List<Order> orders = orderRepository.findAll();

        orders.sort(Comparator.comparing(Order::getPriority));

        Map<String, List<Order>> vehicleAssignments = new HashMap<>();
        Map<String, Double> vehicleRemainingCapacities = new HashMap<>();

        for (Vehicle vehicle : vehicles) {
            vehicleAssignments.put(vehicle.getVehicleId(), new ArrayList<>());
            vehicleRemainingCapacities.put(vehicle.getVehicleId(), vehicle.getCapacity());
        }

        for (Order order : orders){
            String bestVehicleId = null;
            double minDistance = Double.MAX_VALUE;

            for (Vehicle vehicle : vehicles) {
                double remainingCapacity = vehicleRemainingCapacities.get(vehicle.getVehicleId());

                if(remainingCapacity >= order.getPackageWeight()) {
                    DistanceCalculationAlgo distanceCalculationAlgo = new DistanceCalculationAlgo();
                    double distance = distanceCalculationAlgo.distance(
                            vehicle.getCurrentLatitude(), vehicle.getCurrentLongitude(),
                            order.getLatitude(), order.getLongitude()
                    );

                    if(distance < minDistance) {
                        minDistance = distance;
                        bestVehicleId = vehicle.getVehicleId();
                    }
                }
            }

            if (bestVehicleId != null) {
                vehicleAssignments.get(bestVehicleId).add(order);
                double newCapacity = vehicleRemainingCapacities.get(bestVehicleId) - order.getPackageWeight();
                vehicleRemainingCapacities.put(bestVehicleId, newCapacity);
            }
        }

        List<DispatchPlanDTO> dispatchPlans = new ArrayList<>();

        for(Vehicle vehicle: vehicles){
            List<Order> assignedOrders = vehicleAssignments.get(vehicle.getVehicleId());

            if(assignedOrders.isEmpty()) {
                continue;
            }

            double totalLoad = assignedOrders.stream().mapToDouble(Order::getPackageWeight).sum();

            DistanceCalculationAlgo distanceCalculationAlgo = new DistanceCalculationAlgo();

            double totalDistance = assignedOrders.stream().mapToDouble(
                    order -> distanceCalculationAlgo.distance(
                            vehicle.getCurrentLatitude(),
                            vehicle.getCurrentLongitude(),
                            order.getLatitude(),
                            order.getLongitude()
                    )
            ).sum();

            List<OrderDTO> assignedOrderDTOs = assignedOrders.stream().map(
                    order -> {
                        return new OrderDTO(
                                order.getOrderId(),
                                order.getLatitude(),
                                order.getLongitude(),
                                order.getAddress(),
                                order.getPackageWeight(),
                                order.getPriority().name()
                        );
                    }
            ).toList();

            DispatchPlanDTO planDTO = new DispatchPlanDTO(
                    vehicle.getVehicleId(),
                    totalDistance,
                    totalLoad,
                    assignedOrderDTOs
            );

            dispatchPlans.add(planDTO);
        }

        return dispatchPlans;
    }
}
