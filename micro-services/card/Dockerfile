# Run
FROM openjdk:17-oracle
ENV MYAPP_HOME /opt/myapp
WORKDIR $MYAPP_HOME
COPY ./card/target/*.jar $MYAPP_HOME/myapp.jar
ENTRYPOINT java -jar myapp.jar