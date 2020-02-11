FROM anapsix/alpine-java

RUN mkdir -p /app
WORKDIR /app

COPY ./target/ /app

CMD ["java", "-cp", "master-1.0.jar", "com.ia.master.Main"]