# Use the official Maven image to build the app
FROM maven:3.9.6-amazoncorretto-17 AS build

# Configure Maven compiler for Java 17
WORKDIR /app

#COPY pom.xml ./
#COPY waltid-issuer-api/pom.xml ./waltid-issuer-api/
#COPY waltid-issuer-api/src ./waltid-issuer-api/src/
#COPY waltid-libraries/pom.xml ./waltid-libraries/
#COPY waltid-libraries/protocol/pom.xml ./waltid-libraries/protocol/
#COPY waltid-libraries/protocol/waltid-openidc4vc/pom.xml ./waltid-libraries/protocol/waltid-openidc4vc/
#COPY waltid-libraries/protocol/waltid-openidc4vc/common-main/pom.xml ./waltid-libraries/protocol/waltid-openidc4vc/common-main/
#COPY waltid-libraries/protocol/waltid-openidc4vc/common-main/src ./waltid-libraries/protocol/waltid-openidc4vc/common-main/src/

COPY . .

RUN mvn clean package

# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/waltid-issuer-api/target/waltid-issuer-api-1.0-SNAPSHOT.jar myapp.jar

EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "myapp.jar"]
