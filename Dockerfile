FROM docker.io/library/openjdk:17-jdk
MAINTAINER michelmeeuwissen.com
COPY target/phase-voltage-reader-0.0.1.jar phase-voltage-reader-0.0.1.jar

ENV TZ=Europe/Amsterdam
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

ENTRYPOINT ["java","-jar","/phase-voltage-reader-0.0.1.jar"]
