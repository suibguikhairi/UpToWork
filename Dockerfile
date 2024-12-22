FROM openjdk:8
ARG BUILD_NUMBER
ENV APP_VERSION=4.0
EXPOSE 8090
ADD  target/uptowork-$APP_VERSION.jar uptowork-$APP_VERSION.jar
ENTRYPOINT ["java" , "-jar" , "uptowork-$APP_VERSION.jar" ]