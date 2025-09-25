# Ecommerce Order Management System

A Spring Boot based **Ecommerce Order Management System** where customers can place orders for multiple products.  
When an order is placed, a message is published to a Kafka topic (`order-events`).

---

## Features
- Manage **Customers**, **Products**, **Orders**, and **Order Items**
- REST API Endpoints:
  - `POST /api/orders` → Place a new order
  - `GET /api/orders/{id}` → Get order by ID
  - `GET /api/products` → List all products
  - `GET /api/customers` → List all customers
- **Kafka Integration**: Publishes order events on `order-events` topic

---

## Tech Stack
- **Java 17+**
- **Spring Boot** (Web, Data JPA, Kafka)
- **PostgreSQL**
- **Apache Kafka**
- **Hibernate**
