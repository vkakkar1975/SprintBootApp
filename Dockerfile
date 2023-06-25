FROM openjdk:11-ea-jre
MAINTAINER myNAME 
EXPOSE 8080
COPY target/vicky-0.0.1-SNAPSHOT.jar /home/testprj-1.0-SNAPSHOT.jar
ENTRYPOINT  ["java","-jar","/home/testprj-1.0-SNAPSHOT.jar"]