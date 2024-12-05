FROM ghcr.io/egovernments/8-openjdk-alpine:latest

# INSTRUCTIONS ON HOW TO BUILD JAR:
# Move to the location where pom.xml is exist in project and build project using below command
# "mvn clean package"

RUN mkdir /opt/mea

COPY /target/mea-service-1.1.4-SNAPSHOT.jar /opt/mea/mea-api-service.jar

CMD java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 -Xmx64m -Xms64m   -jar /opt/mea/mea-api-service.jar

# NOTE: the two 'RUN' commands can probably be combined inside of a single
# script (i.e. RUN build-and-install-app.sh) so that we can also clean up the
# extra files created during the `mvn package' command. that step inflates the
# resultant image by almost 1.0GB.
