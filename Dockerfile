FROM openjdk:17
EXPOSE 8080
ADD target/bellfam.war bellfam.war
ENTRYPOINT ["java","-jar","/bellfam.war"]