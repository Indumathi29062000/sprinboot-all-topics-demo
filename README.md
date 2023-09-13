# springboot-all-topics-demo

**This project includes configurations for various components and features based on Spring profiles defined in application-{profile}.yml files.**

**Database Configuration:**
- Configured MySQL, MongoDB, and Redis as per project requirements.

**Actuator Endpoints:**
- Configured Spring Boot Actuator endpoints for monitoring and management of the application.

**Code Coverage Reports:**
- Integrated JaCoCo and Maven Surefire Plugin to generate code coverage reports, helping you assess the quality of your codebase.

**Controller Methods:**
- Implemented controller methods to handle HTTP GET, PUT, POST, and other HTTP methods, facilitating the interaction between clients and the application.

**Caching with Redis:**
- Implemented caching using Redis, optimizing data retrieval and improving application performance.

**Logging with Log4j2:**
- Utilized Log4j2 for logging purposes, with ANSI color coding for log messages, providing a visually informative log output.

**ANSI Color Support:**
- Integrated the Jansi dependency to enhance ANSI color support in the logs, making it easier to distinguish log levels and messages.

**Log File Generation:**
- Configured Log4j2 to generate a new log file each time the application is run, allowing you to keep track of log history for different runs.

**Spring Security:**
- Integrated Spring Security for authentication and authorization, with the username and password configured according to the active profile defined in application-{profile}.yml.

**@Profile and @ActiveProfiles:**
- Leveraged the @Profile and @ActiveProfiles annotations to manage and activate profiles for different testing scenarios and environments.
