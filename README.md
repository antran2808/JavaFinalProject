# FinalProject

This is a Java web application project.

## Build Tools

This project uses [Maven](https://maven.apache.org/) as a build tool. The configuration for the build process is located in the [`pom.xml`](FinalProject/pom.xml) file.

## Dependencies

The project has several dependencies, which are managed by Maven and specified in the [`pom.xml`](FinalProject/pom.xml) file. Some of the main dependencies include:

- `jakarta.platform:jakarta.jakartaee-api:10.0.0`
- `com.microsoft.sqlserver:mssql-jdbc:12.6.1.jre11`
- `jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api:3.0.0`
- `org.glassfish.web:jakarta.servlet.jsp.jstl:3.0.1`
- `org.projectlombok:lombok:1.18.32`
- `org.mindrot:jbcrypt:0.4`

## Methods and Functions

The project contains several classes with methods and functions. Some of the main ones include:

- `UserMapper.java`: Contains methods for mapping user data from the database to Java objects.
- `Estate.java`: Contains methods related to estate entities.
- `UserRepository.java`: Contains methods for performing database operations related to users.
- `UserService.java`: Contains methods for performing operations related to user services.
- `DetailController.java`: Contains methods for handling requests related to details.
- `Security.java`: Contains methods for handling security-related operations.
- `BookingError.java`: Contains methods related to booking error entities.
- `BookingMapper.java`: Contains methods for mapping booking data from the database to Java objects.
- `BookingService.java`: Contains methods for performing operations related to booking services.
- `HomeController.java`: Contains methods for handling requests related to the home page.
- `LogoutController.java`: Contains methods for handling logout requests.
- `EstateMapper.java`: Contains methods for mapping estate data from the database to Java objects.

For more details, please refer to the source code in the [`src/main/java/vn/edu/tdt/finalproject`](FinalProject/src/main/java/vn/edu/tdt/finalproject) directory.
Demo: ([https://youtu.be/Vmlmg0m0K1I](https://www.youtube.com/watch?v=Vmlmg0m0K1I&feature=youtu.be)).
