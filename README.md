 # 🚗 Car Workshop Management API (Spring Boot)

## 📌 Overview
This project is a **Spring Boot REST API** for managing a car workshop.  
It allows you to register **customers**, their **vehicles**, and create **appointments** for maintenance or repair.  

The API follows a layered architecture:
- **Entities (Models):** `Customer`, `Vehicle`, `Appointment`  
- **DAO (Repositories):** MySQL persistence layer  
- **Services:** Business logic  
- **Controllers:** REST API endpoints  

⚠️ **Note:** The project is currently **unfinished**. At this stage, only the core entities and endpoints (tested with Postman) are being developed.

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot 3.x**
- **Spring Data JPA (Hibernate)**
- **MySQL**  
- **Maven**  
- **Postman** (for testing)  

---

## 📂 Project Structure
│
├── controller # REST controllers (Customer, Vehicle, Appointment)
├── service # Business logic layer
├── dao # Repositories (Spring Data JPA)
├── model # Entities: Customer, Vehicle, Appointment


## Run the App

mvn spring-boot:run
The API will be available at: http://localhost:8080

## API Endpoints
<img width="858" height="265" alt="Screenshot 2025-09-08 at 21 21 31" src="https://github.com/user-attachments/assets/ac7ee6fc-ff9e-4521-b17b-f4bbe485cee0" />

<img width="1078" height="286" alt="Screenshot 2025-09-08 at 21 22 07" src="https://github.com/user-attachments/assets/20f41e02-bf2e-48e8-8824-81c71d265dfe" />

<img width="869" height="358" alt="Screenshot 2025-09-08 at 21 22 39" src="https://github.com/user-attachments/assets/7d475094-3b30-4238-90d5-71a6f74a7bf7" />




## 🧪 Testing with Postman

Start the Spring Boot app.

Use Postman to send requests to http://localhost:8080.

Verify results in MySQL database.

## 🚀 Future Enhancements

Input validation with annotations (@Valid, @NotNull, etc.)

Error handling & custom exceptions

Use DTOs for cleaner responses

Authentication & role-based access (Spring Security + JWT)

Swagger/OpenAPI documentation


