# This is Dockerfile for my SpringBoot Application image

FROM openjdk:8-jre

VOLUME /tmp

EXPOSE 8888

ARG JAR_FILE=/target/*.war

COPY ${JAR_FILE} cicd.war

RUN echo "I am creating a docker image for my handson"

MAINTAINER "moumitadas0991@gmail.com"

ENTRYPOINT ["java" ,"-jar", "cicd.war"]