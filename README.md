# Product Management API

A simple Spring Boot REST API for managing products using in-memory ArrayList storage.

## Features
- Add new products with validation
- Get product by ID
- Get all products
- In-memory ArrayList storage (no database required)

## Tech Stack
- Java 11
- Spring Boot 2.7.14
- Maven

## How to Run

### 1. Prerequisites
- Java 11 or higher
- Maven 3.6+

### 2. Run Locally
```bash
# Clone/download the project
cd ecommerce-api

# Run with Maven
mvn spring-boot:run

# Or build and run
mvn clean package
java -jar target/ecommerce-api-1.0.0.jar
