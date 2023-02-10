#FROM openjdk:18.0-slim
#COPY target/*.jar app.jar
#EXPOSE 8080
#ENTRYPOINT ["java","-jar","/app.jar"]

#FROM maven:3.8.6-openjdk-18-slim AS build
#WORKDIR /home/app
#COPY . /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
#FROM openjdk:18.0-slim
#EXPOSE 8080
#COPY --from=build /home/app/target/*.jar app.jar
#ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]


#FROM maven:3.8.6-openjdk-18-slim AS build
#WORKDIR /home/app
#
#COPY ./pom.xml /home/app/pom.xml
#COPY ./src/main/java/com/yeahbutstill/oauthwithspingsecurity/controller/HelloWorldController.java /home/app/src/main/java/com/yeahbutstill/oauthwithspingsecurity/controller/HelloWorldController.java
#
#RUN mvn -f /home/app/pom.xml clean package
#
#COPY . /home/app
#RUN mvn -f /home/app/pom.xml clean package
#
#FROM openjdk:18.0-slim
#EXPOSE 8080
#COPY --from=build /home/app/target/*.jar app.jar
#ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]