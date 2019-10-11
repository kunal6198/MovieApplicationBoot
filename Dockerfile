FROM openjdk:11
ADD ./target/MovieApp-0.0.1-SNAPSHOT.jar /usr/src/MovieApp-0.0.1-SNAPSHOT.jar
WORKDIR usr/src
ENTRYPOINT ["java","-jar", "MovieApp-0.0.1-SNAPSHOT.jar"]