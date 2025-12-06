# Auth API

A minimal authentication REST API using **Spring Boot 3**, **Spring Security**, **JWT**, and **H2 Database**.

---

## 📸 Screenshots

### 🔐 Login / Register Dashboard
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/bee9f2b6-7d7a-4c35-8ed9-2ef1dae5948f" />

### 📄 User Login via Postman

<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/c3ae7884-1575-488d-bdd6-494511baa890" />


### 🟢 Login via Swagger UI
---
<img width="1366" height="768" alt="image" src="https://github.com/user-attachments/assets/a3048702-5ec8-4273-b2f2-db2d2a5a77ff" />

## 🚀 Features
- User registration  
- User login with JWT generation  
- Token validation endpoint  
- Stateless authentication  
- BCrypt password hashing  

---

## 📡 Endpoints

| Method | URL             | Description            |
|--------|-----------------|------------------------|
| POST   | /auth/register  | Register a new user    |
| POST   | /auth/login     | Login and receive JWT  |
| POST   | /auth/validate  | Validate JWT token     |

---

## 🛠 Technologies
- Java 21
- Spring Boot 3  
- Spring Security  
- JSON Web Token (JWT)  
- H2 Database  
- Maven  

---

## ▶️ How to Run

```bash
mvn spring-boot:run
