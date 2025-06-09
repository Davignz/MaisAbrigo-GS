FROM openjdk:21-jdk-slim

# Crie um usuário não-root
RUN useradd -ms /bin/bash appuser

# Diretório de trabalho
WORKDIR /app

# Copie o JAR do target
COPY target/gestaoabrigos-0.0.1-SNAPSHOT.jar app.jar

# Variáveis de ambiente com valores default (opcional)
ENV DB_HOST=oracledb
ENV DB_PORT=1521
ENV DB_NAME=mydb
ENV DB_USER=rm554890
ENV DB_PASS=190905
ENV JAVA_OPTS=""

# Expor a porta do serviço
EXPOSE 8080

# Rode o app como usuário não-root
USER appuser

# Comando de inicialização do container
CMD java $JAVA_OPTS -jar app.jar