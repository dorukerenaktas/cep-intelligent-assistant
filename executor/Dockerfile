FROM anapsix/alpine-java

# Install base packages
RUN apk update
RUN apk upgrade
RUN apk add ca-certificates && update-ca-certificates
# Change TimeZone
RUN apk add --update tzdata
ENV TZ=Europe/Istanbul
# Clean APK cache
RUN rm -rf /var/cache/apk/*

RUN mkdir -p /app
WORKDIR /app

COPY ./target/ /app
COPY ./log4j.properties /app/log4j.properties

CMD ["java", "-cp", "executor-1.0.jar", "com.ia.executor.Main"]