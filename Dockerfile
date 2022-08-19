FROM amazoncorretto:17
ARG JAR=target/company_project_rest_api_jwt-0.0.1-SNAPSHOT.jar
COPY ${JAR} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
EXPOSE 8000