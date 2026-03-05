FROM eclipse-temurin:21-jdk
LABEL authors="phuongnd"

WORKDIR /app

COPY target/account-service-0.0.1-SNAPSHOT.jar /app/account-service-0.0.1-SNAPSHOT.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/account-service-0.0.1-SNAPSHOT.jar"]