FROM java:8
VOLUME /tmp
ADD  spring-boot-journal-0.0.1-SNAPSHOT.war journal.war
ENV SPRING_PROFILES_ACTIVE docker
EXPOSE 8443
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/journal.war"]