FROM openjdk:17-jdk-alpine3.13
RUN mkdir /app
WORKDIR /app
COPY target/*.jar /app/app.jar
CMD ["java", "-jar", "app/app.jar"]