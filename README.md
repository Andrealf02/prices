# Shopping Prices Application

This project is a Java-based product pricing management application that follows best development practices, is based on Domain-Driven Design (DDD) architecture, and utilizes the Spring Boot framework to ensure scalability and modularity. The project includes a comprehensive set of integration tests to guarantee the quality and reliability of the system.

## Technologies Used

- **Java**
- **Spring Boot**
- **JPA (Java Persistence API)**
- **MySQL**
- **Gradle**
- **Testing**

## Project Structure

The project structure adheres to DDD principles and is organized into different layers:

- **org.main.application:** Contains DTO (Data Transfer Object) classes for communication between layers.

- **org.main.domain:** Contains classes representing entities and domain logic, such as the `Price` class.

- **org.main.infrastructure:** Contains implementations of repositories, services, and controllers, following Spring's best practices.

- **org.main.infrastructure.exceptions:** Exception classes specific to the application.

- **org.main.shoppingprices:** Main class `ShoppingPricesApplication` that starts the Spring Boot application.

## Database

The application uses MySQL as a database with tables for products, prices, stores, and a price history.

An SQL script (`shopping_prices_schema.sql`) is provided to create these tables.

## Price Query

The main functionality is price querying through the `PriceController`. It uses the `ConsultPricesUseCase` service to provide responses in the `PriceDTO` format.

## Price Update

The application provides a transactional interface for updating prices. The `ConsultPricesUseCaseImpl` service facilitates price updates based on the provided brand, product, and date.

## Testing

Unit and integration tests have been included to ensure code quality and system functionality.

## Running the Project

Make sure you have a MySQL database set up and adjust the credentials in the `application.properties` file. Run the `ShoppingPricesApplication` class to start the application.

Explore, manage, and update your product prices with the confidence of a robust design and comprehensive testing!

