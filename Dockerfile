FROM java:openjdk-8-jdk

COPY target/fullstack-java-teste-swarm.jar /opt/fullstack-java-teste-swarm.jar

EXPOSE 8080

CMD ["java","-jar","/opt/fullstack-java-teste-swarm.jar"]