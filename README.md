# Secure Spring Boot API with JWT Authentication

This project demonstrates how to build a secure Spring Boot API using JWT (JSON Web Token) for authentication. It covers user registration, login, and protects API endpoints with token-based authorization.

## Features:

- **User Registration:** Allows new users to create accounts with email and password.
- **User Login:** Authenticates users and generates JWT tokens upon successful login.
- **JWT Authentication:** Secures API endpoints using JWT. Only authenticated users with valid tokens can access protected resources.
- **Exception Handling:** Provides centralized exception handling for authentication and authorization errors.

## Technologies Used:

- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- JWT (JJWT library)
- Lombok

## Project Structure:

- **com.service.auth.controllers:** Contains REST controllers for authentication endpoints (signup, login).
- **com.service.auth.dtos:** Defines Data Transfer Objects (DTOs) for request and response payloads.
- **com.service.auth.models:** Contains the User entity representing users in the database.
- **com.service.auth.service:** Implements the business logic for authentication and JWT operations.
- **com.service.auth.exception:** Provides custom exception handling for authentication and authorization errors.
- **application.properties:** Configuration file for database connection, JWT secret key, and other settings.

## Getting Started:

1. **Clone the repository:**
   ```bash
   git clone https://github.com/your-username/spring-boot-jwt-auth.git
   ```
2. **Create MySQL Database:**
   - Create a MySQL database named `taskdb`.
3. **Update Configuration:**
   - Open `application.properties` and update the database connection details (connection url, username, password).
   - Set a strong secret key for JWT signing in `security.jwt.secret-key`.
4. **Build and Run:**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

## API Endpoints:

| Endpoint        | Method | Description                | Access Control |
|-----------------|--------|----------------------------|----------------|
| /auth/signup   | POST   | Register a new user        | Public         |
| /auth/login    | POST   | Authenticate and get token | Public         |
| /your-api/**   | GET/POST/PUT/DELETE | Protected API endpoints  | Authenticated   |

## Example Usage:

1. **Register a new user:**
   ```bash
   curl -X POST -H "Content-Type: application/json" \
        -d '{"email": "user@example.com", "password": "password", "fullName": "John Doe"}' \
        http://localhost:8005/auth/signup
   ```
2. **Login with the registered user:**
   ```bash
   curl -X POST -H "Content-Type: application/json" \
        -d '{"email": "user@example.com", "password": "password"}' \
        http://localhost:8005/auth/login
   ```
3. **Access protected API endpoint with the JWT token:**
   ```bash
   curl -H "Authorization: Bearer <your_jwt_token>" \
        http://localhost:8005/your-api/resource
   ```

## Security Considerations:

- Use a strong and unique secret key for JWT signing.
- Store the secret key securely.
- Implement password hashing and salting for user passwords.
- Use HTTPS to protect data transmission.
- Regularly update dependencies to address security vulnerabilities.

This project provides a basic implementation of JWT authentication in a Spring Boot API. You can further enhance it by adding features like:

- Role-based authorization
- JWT refresh tokens
- Two-factor authentication
- Integration with an identity provider
