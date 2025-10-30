# ---------- Build stage (uses Maven with JDK 21) ----------
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app

# copy maven files first for better cache
COPY pom.xml .
# if you use maven wrapper (mvnw) you can also copy it; but using maven image is fine
# copy source
COPY src ./src

# Build jar (skip tests to speed up)
RUN mvn -B clean package -DskipTests

# ---------- Run stage (slim runtime with JDK 21) ----------
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

# copy the built jar from build stage (adjust name if needed)
COPY --from=build /app/target/*.jar app.jar

# Expose port (optional)
EXPOSE 8080

ENTRYPOINT ["java","-jar","/app/app.jar"]
