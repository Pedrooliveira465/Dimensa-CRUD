FROM openjdk:17-jdk-slim

# Copiando o arquivo .jar para o container
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expõe a porta que a aplicação Spring Boot irá rodar
EXPOSE 8080

# Comando para rodar a aplicação Spring Boot
ENTRYPOINT ["java", "-jar", "/app.jar"]