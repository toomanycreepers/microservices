FROM openjdk:17-jdk-slim
WORKDIR /email
COPY target/mail_sender-0.0.1-SNAPSHOT.jar email.jar
ENTRYPOINT ["java", "-jar", "email.jar"]