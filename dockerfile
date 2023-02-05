FROM openjdk
WORKDIR /app
EXPOSE 8080

COPY . .
RUN mvn clean package

COPY ./target/demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java","-jar" ,"app.jar"]
