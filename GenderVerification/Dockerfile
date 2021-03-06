FROM openjdk:15-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/GenderVerification-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
COPY male.txt male.txt
COPY female.txt female.txt
ENTRYPOINT ["java","-jar","/app.jar"]
