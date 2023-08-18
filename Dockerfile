FROM openjdk:17-jdk-alpine

LABEL maintainer="pateluday07@gmail.com"

VOLUME /tmp

COPY /target/*.jar *.jar

ENTRYPOINT ["java","-jar","*.jar"]