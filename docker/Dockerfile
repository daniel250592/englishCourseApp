FROM openjdk:11
RUN mkdir -p /usr/src/ispeak
COPY prework-0.0.1-SNAPSHOT.jar /usr/src/ispeak
WORKDIR /usr/src/ispeak
ENTRYPOINT ["java","-jar","-Dspring.datasource.url=jdbc:mysql://192.168.238.130:3306/ispeak",  "prework-0.0.1-SNAPSHOT.jar"]
