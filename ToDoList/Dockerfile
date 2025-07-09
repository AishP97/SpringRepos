# Use a lightweight JDK base image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy the jar file into the container
COPY target/ToDoList-0.0.1-SNAPSHOT.jar app.jar

# Expose port (adjust to your Spring Boot app's port if different)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]
