FROM openjdk:17-jdk-slim
WORKDIR /sms
COPY target/sms_sender-0.0.1-SNAPSHOT.jar sms.jar
ENTRYPOINT ["java", "-jar", "sms.jar"]