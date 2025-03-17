# Vehicle Maintenance System

A comprehensive JavaFX application for managing vehicle maintenance operations.

## Features

- Customer management
- Vehicle registration and tracking
- Service appointments
- Mechanic assignment
- Invoicing and payment tracking

## Getting Started

### Prerequisites

- Java JDK 11 or newer
- Maven 3.6 or newer

### Running the Application

1. Clone the repository
2. Navigate to the project directory
3. Run the application using one of these methods:

#### Windows
```
run.bat
```

#### Linux/Mac
```
chmod +x run.sh
./run.sh
```

### Building from Source

#### Windows
```
build.bat
```

#### Linux/Mac
```
chmod +x build.sh
./build.sh
```

## Default Login Credentials

The application is pre-loaded with sample data including:

- Admin user: admin@vehicle-maint.com / admin123
- Manager user: manager@vehicle-maint.com / manager123

## Database

This application uses H2 database by default, stored in the file `vehiclemaintdb.mv.db` in the application directory.

To switch to another database:
1. Update connection settings in `src/main/resources/hibernate.cfg.xml`
2. Add the appropriate JDBC driver to `pom.xml`

## Testing

Run tests with:
```
mvn test
```
