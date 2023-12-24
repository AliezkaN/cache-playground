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

## Load Testing with JMeter

Load testing allows you to assess the performance and scalability of your application under various conditions. The project includes a JMeter load testing setup in the `jmeter` folder. Follow these steps to perform load testing:

### Step 1: Download JMeter

[Download Apache JMeter](https://jmeter.apache.org/download_jmeter.cgi)

Choose the appropriate version and download the binary zip or tar.gz file.

### Step 2: Extract JMeter

Once the download is complete, extract the contents of the downloaded file to a location on your machine.

### Step 3: Run JMeter

Navigate to the `bin` directory inside the extracted JMeter folder and run the following command to start JMeter:

   ```shell
   jmeter -t "Path to PlaygroundTest.jmx"
   ```

It will open jmeter GUI with configured test plan

![jmeter_user_defined_variables.jpg](usage%2Fjmeter_user_defined_variables.jpg)

### Step 4: Configure Test Parameters

User-defined variables for test parameters have been defined in the JMX file (PlaygroundTest.jmx). You can modify these variables directly in the JMeter GUI or by editing the JMX file.

Additionally, if you want to change the path to the CSV file containing `personIds`, ensure that the `CSV Data Set Config` element in the JMX file (`PlaygroundTest.jmx`) is configured with the correct path.

![jmeter_csv_data_config.jpg](usage%2Fjmeter_csv_data_config.jpg)

### Step 5: Run the Test

After configuring the test plan, you can run the load test using the following command in your terminal or command prompt:

```shell
jmeter -n -t path/to/PlaygroundTest.jmx -l path/to/examples/results.jtl -e -o path/to/output/folder
```

Explanation of the command parameters:

- `-n` : Run JMeter in non-GUI mode.
- `-t path/to/PlaygroundTest.jmx`: Specify the path to your JMX test plan file (PlaygroundTest.jmx).
- `-l path/to/examples/results.jtl`: Specify the path and name of the CSV file where you want to keep the results (replace with your preferred file name).
- `-e` : Generate an HTML report dashboard after the test.
- `-o path/to/output/folder`: Specify the path to the output folder where you want to save the results (replace with your preferred folder path).

Make sure to replace path/to/PlaygroundTest.jmx, path/to/examples/results.jtl, and path/to/output/folder with the actual paths and filenames you want to use.

## Step 6: Analyze Results

Once the test is complete, you can analyze the results using the generated HTML report in the specified output folder.

Feel free to explore and customize the load testing setup based on your specific use case. If you encounter any issues or have questions, refer to the JMeter documentation or seek assistance in the project's community forums.

Happy load testing!

## Load Tests

### 1. Cache Load Test Statistics (Command Line)

![cache_load_test.jpg](usage%2Fcache_load_test.jpg)

### 2. Plain Load Test Statistics (Command Line)

![plain_load_test.jpg](usage%2Fplain_load_test.jpg)

### 3. Cache Load Test Report (HTML)

![cache_report_dashboard.jpg](usage%2Fcache_report_dashboard.jpg)

### 4. Plain Load Test Report (HTML)
![plain_report_dashboard.jpg](usage%2Fplain_report_dashboard.jpg)