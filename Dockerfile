FROM openjdk:17
EXPOSE 8082

WORKDIR /app

# Copie du fichier JAR dans le répertoire de travail de l'image Docker
COPY build/libs/sigili.jar /app/sigili.jar

ENTRYPOINT ["java", "-jar", "sigili.jar"]