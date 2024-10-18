FROM openjdk:11
ARG JAR_FILE=target/Graphql_withAuth_And_Entyties-0.0.1-SNAPSHOT.jar
WORKDIR /opt/app
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]