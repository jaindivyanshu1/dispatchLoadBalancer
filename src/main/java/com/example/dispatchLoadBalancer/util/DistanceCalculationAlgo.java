package com.example.dispatchLoadBalancer.util;

import com.example.dispatchLoadBalancer.util.algo.HaversineAlgo;

public class DistanceCalculationAlgo {

    private final HaversineAlgo haversineAlgo = new HaversineAlgo();

    public double distance(double lat1, double lon1, double lat2, double lon2){
        return haversineAlgo.distance(lat1, lon1, lat2, lon2);
    }

}
