FROM openjdk:11-jdk-slim
LABEL maintainer=“zhar.feda@yandex.cu”

ARG PORT_ENV=8010
ENV RCSLAB_T1_PORT=${PORT_ENV}
ENV RCSLAB_T1_DB_PATH=/

ADD ./build/libs/InTest-1.1.jar /
ADD ./db/data.sqlite ./

ENTRYPOINT exec java -Dspring.profiles.active=dev -jar ./InTest-1.1.jar
