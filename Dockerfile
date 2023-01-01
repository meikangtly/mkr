# Start with a base image containing Java runtime
FROM openjdk:19 as builder
WORKDIR "/demo"
COPY . .
RUN chmod +x ./mvnw
RUN ./mvnw clean package -DskipTests

FROM openjdk:19
COPY --from=builder /demo/target/*.jar /demo/demo.jar
WORKDIR "/demo"
CMD ["java", "-jar", "demo.jar"]

# FROM openjdk:19 as builder
# # Add Maintainer Info
# LABEL maintainer="pancras@gx3000"
# # Add a volume pointing to /tmp
# VOLUME /tmp
# # Make port 8080 available to the world outside this container
# EXPOSE 8080
# # The application's jar file (when packaged)
# ARG JAR_FILE=target/*.jar
# # Add the application's jar to the container
# COPY --from=builder /target/*.jar demo.jar
# #ADD ${JAR_FILE} demo.jar
# # Run the jar file
# ENTRYPOINT ["java","-jar","/demo.jar"]

