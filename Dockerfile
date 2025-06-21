FROM openjdk:26-slim-bullseye
WORKDIR /app
COPY target/EmailVerifier-0.0.1-SNAPSHOT.jar EmailVerifier.jar
ENTRYPOINT ["java","-jar","EmailVerifier.jar"]