# Pull base image
From tomcat:8-jre8

# Maintainer
MAINTAINER "PierreCaruyer <pierrecaruyer@gmail.com">

# Copy to images tomcat path
ADD target/tomcat-0.0.1-SNAPSHOT.war /var/lib/tomcat8/webapps
