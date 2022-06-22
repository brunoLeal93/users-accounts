FROM openjdk:18-jdk-alpine
LABEL maintainer="bruno.leal.U6081428"
ADD target/users-accounts-0.0.1-SNAPSHOT.jar users-accounts-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "users-accounts-0.0.1-SNAPSHOT.jar"]