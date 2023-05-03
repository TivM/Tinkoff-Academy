FROM openjdk:19

ARG JAR_FILE=bot/target/*.jar
WORKDIR /app/bot
COPY ${JAR_FILE} bot.jar

RUN ECHO "hello"
ENTRYPOINT exec java -jar bot.jar