# Step 1: Java base image use karo
FROM openjdk:17-jdk-slim

# Step 2: Jar file copy karo
COPY target/*.jar app.jar

# Step 3: Run the jar file
ENTRYPOINT ["java", "-jar", "/app.jar"]
