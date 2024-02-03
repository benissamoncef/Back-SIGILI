FROM debian:bullseye-slim

# Installation de OpenJDK et PostgreSQL
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk postgresql

# Création du répertoire de l'application
WORKDIR /app

# Copie de votre application
COPY build/libs/Back-end-0.0.1-SNAPSHOT.jar /app/sigili.jar

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "/app/sigili.jar"]
