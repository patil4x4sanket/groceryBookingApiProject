## use base image as openjdk:8
# FROM java:8-jdk-alpine    ## this is deprecated
FROM openjdk:8

EXPOSE 8080

## adding jar to docker image
ADD target/*.jar groceryBookingApiProject-1.0.jar

## run the jar file
ENTRYPOINT ["java", "-jar", "groceryBookingApiProject-1.0.jar"]