FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=test.MyJava_bot
ENV BOT_TOKEN=5542775018:AAErvRG6qdA7LNMTaeh1SPZwd7VJ9G9NIlc
ENV BOT_DB_USERNAME=jtb_db_user
ENV BOT_DB_PASSWORD=jtb_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "app.jar"]