FROM openjdk:17

# Installation de PostgreSQL
RUN apt-get update && apt-get install -y postgresql

# Configuration de la base de données
ENV SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/CSABDD
ENV SPRING_DATASOURCE_USERNAME=moncef
ENV SPRING_DATASOURCE_PASSWORD=18007022


EXPOSE 8082
ADD build/libs/Back-end-0.0.1-SNAPSHOT.jar sigili.jar
ENTRYPOINT ["java","-jar","/sigili.jar"]