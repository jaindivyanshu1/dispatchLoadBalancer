# 📦 Dispatch Load Balancer API

A Spring Boot-based backend system designed to manage delivery order dispatching and vehicle assignment using load balancing principles.

---

# Demo

[Watch Demo Vedio](./demo.mov)


## ✅ Requirements & Assumptions

- System accepts a list of delivery orders and vehicles.
- Orders contain location, weight, and priority.
- Vehicles contain location and capacity.
- Orders are stored and later assigned to vehicles using load-balancing rules.
- All input is validated at controller level.
- Errors return meaningful HTTP messages via GlobalExceptionHandler.
- System is stateless and scalable (designed to extend to Redis/async processing).

---

## 🛠️ Tech Stack

| Layer       | Tech Used                      |
|-------------|--------------------------------|
| Backend     | Java 17+, Spring Boot 3+       |
| Persistence | Spring Data JPA + PostgreSQL   |
| API Docs    | springdoc-openapi (Swagger UI) |
| Dev Tools   | Spring Boot DevTools           |
| Validation  | Jakarta Bean Validation        |
| Testing     | JUnit 5, Spring MockMvc        |

---

## 💻 System Requirements

- Java 17+
- Maven 3.6+
- PostgreSQL (local or remote)
- IDE like IntelliJ / VSCode (recommended)

---

## 🚀 Setup & Run (Local)

### 📦 Step 1: Clone Repo
```bash
git clone https://github.com/yourusername/dispatchLoadBalancer.git
cd dispatchLoadBalancer
```

### ⚙️ Step 2: Configure DB
> Update src/main/resources/application.properties:
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/dispatch_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### ▶️ Step 3: Run App
```bash
./mvnw spring-boot:run
```

### 🌐 Step 4: Access Swagger Docs
```bash
http://localhost:8080/swagger-ui.html
```

