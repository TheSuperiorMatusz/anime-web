FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package

FROM openjdk:17

WORKDIR /app

ENV DB_URL=jdbc:postgresql://host.docker.internal:5432/anime_web
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=""

COPY --from=build /app/target/*.jar app.jar

CMD ["java", "-jar", "app.jar"]