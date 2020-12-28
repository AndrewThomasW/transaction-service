FROM adoptopenjdk:11-jre-hotspot
ADD target/transaction-service-0.0.1-SNAPSHOT.jar transaction-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java","-jar","transaction-service-0.0.1-SNAPSHOT.jar"]
