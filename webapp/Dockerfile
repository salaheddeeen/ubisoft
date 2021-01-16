FROM openjdk:11
EXPOSE 8081
ARG JAR_FILE=target/webapp-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} webapp.jar
ENTRYPOINT ["java","-jar","/webapp.jar"]