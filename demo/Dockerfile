FROM alpine/git
RUN mkdir /app
WORKDIR /app
RUN pwd
RUN ls -l
RUN git clone https://github.com/jeyasekar/springboot_docker.git
RUN pwd
RUN ls -l
WORKDIR /app
RUN pwd
RUN ls -l

FROM maven:3.5-jdk-8-alpine as builder
WORKDIR /app/springboot_docker/demo
COPY --from=0 /app/springboot_docker/demo /app/springboot_docker/demo
RUN pwd
RUN ls -l
# Build a release artifact.
RUN mvn package -DskipTests

FROM adoptopenjdk/openjdk8:jdk8u202-b08-alpine-slim
# Copy the jar to the production image from the builder stage.
WORKDIR /app/springboot_docker/demo
COPY --from=builder /app/springboot_docker/demo /app/springboot_docker/demo
ENTRYPOINT ["java", "-jar","/app/springboot_docker/demo/target/demo-service.jar"]