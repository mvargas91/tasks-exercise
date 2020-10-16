FROM artifactory.apps.bancolombia.com/devops/openjdk8-openj9:x86_64-alpine-jdk8u212-b03_openj9-0.14.0-slim
ADD *.jar app.jar
CMD java -XX:+UseContainerSupport -Djava.security.egd=file:/dev/./urandom -jar /app.jar