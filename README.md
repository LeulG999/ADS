# ADS Appointment CLI

Adventist Dental Surgeries (ADS) appointment management CLI application.

## Features

- Display all appointments as pretty JSON.
- Display quarterly upcoming appointments as pretty JSON.
- Uses an in-memory appointment repository.
- Uses Jackson `ObjectMapper` through `JsonUtil` for JSON output.

## Requirements

- Java 17 or newer
- Maven 3.9 or newer
- Docker, optional

## Build

```powershell
mvn clean package
```

This creates an executable shaded JAR:

```text
target/ADS-1.0-SNAPSHOT.jar
```

## Run With Maven

```powershell
mvn exec:java
```

## Run The JAR

```powershell
java -jar target/ADS-1.0-SNAPSHOT.jar
```

## CLI Options

```text
Welcome to ADS Appointment Menu
1. Display all appointments
2. Display quarterly upcoming appointments
3. Exit
```

## Docker Build

```powershell
docker build -t ads-appointment-cli .
```

## Docker Run

```powershell
docker run -it --rm ads-appointment-cli
```

## Application Flow

```text
App -> AppointmentCli -> AppointmentService -> AppointmentRepository
```

JSON conversion flow:

```text
AppointmentCli -> JsonUtil
```
