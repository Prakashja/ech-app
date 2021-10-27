# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine



# copy JAR into image
COPY target/rest-app.jar /rest-app.jar

# run application with this command line
CMD ["/usr/bin/java", "-jar", "-Dspring.profiles.active=default", "/rest-app.jar"]
