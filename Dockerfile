FROM openjdk:17
EXPOSE 8082
ADD build/libs/Back-end-0.0.1-SNAPSHOT.jar sigili.jar
ENTRYPOINT ["java","-jar","/sigili.jar"]
