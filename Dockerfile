# Starting with a base image containing Java runtime and Maven for building and packaging purpose
FROM maven:3.8.1-openjdk-11-slim as build

RUN mkdir -p /workspace

WORKDIR /workspace

# Coping pom.xml and code-base to our container
COPY pom.xml .
COPY src ./src

# Packaging the application
RUN mvn clean package -Dmaven.test.skip=true

# Starting with a base image containing Java runtime to deploy/ copy the created jar in container
FROM openjdk:11-jdk-slim

WORKDIR /app

# Copy the created jar from build image to container
COPY --from=build /workspace/target/groceryBookingApiProject-1.0.jar /app

# Entry point to run our jar
ENTRYPOINT ["java","-jar","groceryBookingApiProject-1.0.jar"]