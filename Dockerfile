FROM alpine:3.13

ENV LANG en_US.UTF-8
ENV LANGUAGE en_US:en
ENV LC_ALL en_US.UTF-8

RUN wget --quiet https://cdn.azul.com/public_keys/alpine-signing@azul.com-5d5dc44c.rsa.pub -P /etc/apk/keys/ && \
    echo "https://repos.azul.com/zulu/alpine" >> /etc/apk/repositories && \
    apk --no-cache add zulu11-jdk=11.0.10-r1

ENV JAVA_HOME=/usr/lib/jvm/zulu11-ca
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/Towers_Of_Hanoi-Docker-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]