FROM openjdk:17-jdk-slim-buster
COPY ./build/libs/ftgo-consumer-starter-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

LABEL org.opencontainers.image.source="https://github.com/michael-neuhold/ftgo-services"