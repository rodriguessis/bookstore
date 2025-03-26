### Fase de Build
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

COPY pom.xml /app
RUN mvn dependency:go-offline

COPY src /app/src
RUN mvn clean install

RUN ls -la /app/target

### Fase de Runtime
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar /app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
