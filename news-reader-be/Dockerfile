FROM openjdk:8 AS BUILD_IMAGE
LABEL maintainer d.ghilardi

ENV APP_HOME=/root/dev/news-reader/
RUN mkdir -p $APP_HOME/src/main/java
WORKDIR $APP_HOME

COPY gradle gradle
COPY gradlew .
COPY build.gradle .
COPY settings.gradle .

RUN ./gradlew dependencies

COPY . .

RUN ./gradlew clean
RUN ./gradlew build -i

FROM openjdk:8-jre-alpine
LABEL maintainer d.ghilardi

VOLUME /tmp
WORKDIR /root/

COPY --from=BUILD_IMAGE /root/dev/news-reader/build/libs/news-reader*.jar news-reader.jar

EXPOSE 8890
EXPOSE 6565

ENTRYPOINT java $JVM_OPTS -Djava.security.egd=file:/dev/./urandom -jar /root/news-reader.jar
