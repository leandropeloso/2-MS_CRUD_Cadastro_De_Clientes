FROM openjdk:11-jdk
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} dpsstorageapi.jar
ENTRYPOINT ["java","-Dspring.profiles.active=dev","-jar","/dpsstorageapi.jar"]
