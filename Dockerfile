FROM tomcat:8.0.20-jre8

ENV JAVA_OPTS="-Djava.net.preferIPv4Star=true -Djava.net.preferIPv4Addresses=true"

COPY target/fullstack-java-teste.war /usr/local/tomcat/webapps/fullstack-java-teste.war
COPY tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml

EXPOSE 8080

#CMD ["java","-jar","/opt/fullstack-java-teste-swarm.jar"]
