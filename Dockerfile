FROM openjdk:21-jdk-alpine
ADD target/basic-spring-app-1.0-SNAPSHOT.jar basic-spring-app.jar
EXPOSE 8089
CMD ["java","-jar","basic-spring-app.jar"]