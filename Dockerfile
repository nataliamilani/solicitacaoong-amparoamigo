FROM openjdk:11-jre-slim

WORKDIR /app

EXPOSE 8081

ENV DATABASE_CONNECTION_URL="jdbc:mysql://dbsolicitacao:3306/solicitacaodb"
ENV EUREKA_CONNECTION_URL="http://eureka:8761"

COPY target/solicitacaoong.jar /app/solicitacaoong.jar

ENTRYPOINT ["java", "-jar", "solicitacaoong.jar"]