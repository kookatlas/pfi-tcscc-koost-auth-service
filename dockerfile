# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application JAR file into the container
# Assuming your Spring Boot application builds an executable JAR file
# and it's located in the 'target' directory with this exact name.
# You might need to adjust the path based on your Maven/Gradle build output.
COPY target/pfi-tcscc-koost-auth-service.jar app.jar

# Expose the port that your Spring Boot application runs on.
# Spring Boot typically defaults to port 8080. Adjust if yours is different.
EXPOSE 8081

# Define the command to run your Spring Boot application.
# 'java -jar' is the standard way to execute a Spring Boot executable JAR.
# 'app.jar' is the name we gave to the copied JAR file in the previous step.
ENTRYPOINT ["java", "-jar", "app.jar"]

# You can add more configurations here if needed, such as:
# - Setting environment variables using the 'ENV' instruction.
# - Adding additional files or configurations using the 'COPY' instruction.
# - Running commands before starting the application using the 'RUN' instruction.
# - Specifying the user to run the application as using the 'USER' instruction.