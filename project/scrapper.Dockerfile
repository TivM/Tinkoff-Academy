FROM openjdk:17-slim

ARG JAR_FILE=scrapper/target/*.jar
WORKDIR /app/scrapper
COPY ${JAR_FILE} scrapper.jar

RUN ECHO "hello"
ENTRYPOINT exec java -jar scrapper.jar