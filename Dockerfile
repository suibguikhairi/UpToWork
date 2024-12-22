FROM openjdk:8
ARG BUILD_NUMBER
ENV APP_VERSION=${BUILD_NUMBER}
EXPOSE 8090
ADD  target/uptowork-$APP_VERSION.jar uptowork-$APP_VERSION.jar
ENTRYPOINT ["java" , "-jar" , "uptowork-$APP_VERSION.jar" ]