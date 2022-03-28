FROM maven:3.8.4-jdk-11-slim AS build

RUN mkdir /app
WORKDIR /app
COPY . /app
RUN mvn clean test

CMD java