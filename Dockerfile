FROM openjdk:17
EXPOSE 8082
ADD target/sigili.jar sigili.jar
ENTRYPOINT ["java","-jar","/sigili.jar"]