FROM java:8
VOLUME /tmp
EXPOSE 9090
ADD /build/libs/vehicleApp-0.0.1-SNAPSHOT.jar vehicleApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","vehicleApp-0.0.1-SNAPSHOT.jar"]