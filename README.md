# Auth API

A minimal authentication REST API using **Spring Boot 3**, **Spring Security**, **JWT**, and **H2 Database**.

---

## 📸 Screenshots

### 🔐 Login / Register Dashboard
![Dashboard Screenshot](./screenshots/dashboard.png)

### 📄 User Login via Postman
![Postman Login](./screenshots/postman-login.png)

### 🟢 Token Validation
![Token Validation](./screenshots/token-validation.png)

---

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
- Java 17+  
- Spring Boot 3  
- Spring Security  
- JSON Web Token (JWT)  
- H2 Database  
- Maven  

---

## ▶️ How to Run

```bash
mvn spring-boot:run
