FROM openjdk:11
EXPOSE 8081
ARG JAR_FILE=target/webservice-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} webservice.jar
ENTRYPOINT ["java","-jar","/webservice.jar"]