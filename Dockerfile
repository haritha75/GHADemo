# Use an official OpenJDK runtime as a parent image
FROM eclipse-temurin:17-jre

# Set the working directory
WORKDIR /app

# Copy the jar file into the container
COPY target/*.jar /app/myapp.jar

EXPOSE 8000

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/myapp.jar"]
