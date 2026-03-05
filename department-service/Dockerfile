FROM eclipse-temurin:21-jdk

LABEL authors="phuongnd"

WORKDIR /app

COPY target/department-service-0.0.1-SNAPSHOT.jar /app/department-service-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/department-service-0.0.1-SNAPSHOT.jar"]