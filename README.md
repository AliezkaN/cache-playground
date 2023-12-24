# Cache Playground Spring Boot App

## Overview
This is a Spring Boot application named `cache-playground` that demonstrates the usage of Caffeine cache

## Prerequisites

Before you begin, ensure you have met the following requirements:

- **Java Development Kit (JDK)**: Ensure you have Java 21 installed on your system.
- **Apache Maven**: Make sure you have Maven installed for building and managing the project.
- **Spring Boot**: This project is based on Spring Boot.

---

## Getting Started

To get started with this project, follow these steps:

1. Clone the repository to your local machine:

   ```shell
   git clone https://github.com/AliezkaN/cache-playground.git
   ```

2. Navigate to the project directory:

   ```shell
   cd cache-playground
   ```

3. Build the project using Maven:

   ```shell
   mvn clean install
   ```
---

## Application Start up

To start the application, you can execute it in one of the following ways:

1. Using Executable JAR

   ```shell
   java -jar target/cache-playground-0.0.1-SNAPSHOT.jar
   ```
2. Using Maven

   ```shell
   mvn spring-boot:run
   ```

---

## Cache configuration

The caching behavior of the application can be configured in various ways, allowing users to enable or disable the cache and customize its parameters.

### Configuration in `application.yml`
To configure the cache using the `application.yml` file, you can update the following properties:

```yaml
playground:
  cache:
    enabled: true  # Set to 'true' to enable cache, 'false' to disable
    initialSize: 100  # Initial capacity of the cache
    maxSize: 1000  # Maximum size of the cache
    expireTime: 60  # Expiration time for cache entries
    timeUnit: SECONDS  # Time unit for expiration (SECONDS, MINUTES, HOURS, DAYS)
```

Adjust the values according to your specific requirements.

### Command-Line Parameters

Alternatively, you can configure the cache on application start-up using command-line parameters. For example:

   ```shell
   java -jar target/cache-playground-0.0.1-SNAPSHOT.jar --playground.cache.enabled=false
   ```

The above command disables the cache.

Note: Command-line parameters take precedence over values set in the application.yml file. If a parameter is provided on the command line, it will override the corresponding property in the configuration file.

Feel free to experiment with different configurations to optimize the cache behavior for your use case.

---