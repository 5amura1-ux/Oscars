# Vehicle Maintenance System

A comprehensive vehicle maintenance management system built with JavaFX and Hibernate ORM.

## Features

- Customer management
- Vehicle tracking
- Service appointment scheduling
- Mechanic assignment
- Invoice generation
- Payment processing
- Audit logging

## Technology Stack

- Java 11+
- JavaFX 15 for the UI
- Hibernate ORM 5.4.32 for database interactions
- Oracle Database for data storage
- Gradle for build management

## Setup Instructions

1. Ensure you have Java 11+ installed
2. Configure Oracle database connection in `src/main/resources/hibernate.cfg.xml`
3. Run `gradle build` to compile the application
4. Run `gradle run` to start the application

## Database Configuration

Update the following properties in both `hibernate.cfg.xml` and `application.properties`:

```
hibernate.connection.url
hibernate.connection.username
hibernate.connection.password
```

## Project Structure

- `model`: Entity classes mapped to database tables
- `repository`: Data access layer with Hibernate
- `service`: Business logic layer
- `controller`: JavaFX controllers
- `util`: Utility classes including HibernateUtil
- `resources/fxml`: JavaFX UI layouts
