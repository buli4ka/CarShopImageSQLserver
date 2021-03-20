FROM openjdk:8
EXPOSE 8080
ADD target/auto.jar auto.jar
ENTRYPOINT ["java", "jar","auto.jar"]