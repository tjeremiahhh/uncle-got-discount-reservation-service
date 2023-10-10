# Start with a base iamge Java runtime
FROM openjdk:17

# Make port 8080 available to the world outside this container
EXPOSE 8080

ADD target/uncle-got-discount-reservation-service.jar uncle-got-discount-reservation-service.jar

# Run the jar file
ENTRYPOINT ["java","-jar","uncle-got-discount-reservation-service.jar"]