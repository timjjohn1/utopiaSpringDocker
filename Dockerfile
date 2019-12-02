FROM archlinux/base

EXPOSE 443
EXPOSE 8443
EXPOSE 8090
EXPOSE 3306

MAINTAINER tim.johnson@smoothstack.com

RUN pacman -Syu --noconfirm
RUN pacman -S git jdk8-openjdk maven --noconfirm


ENV SPRING_DATASOURCE_URL="jdbc:mysql://database-1.crhcwiispks5.us-east-2.rds.amazonaws.com:3306/utopia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
ENV SPRING_DATASOURCE_PASSWORD="password"
ENV SPRING_DATASOURCE_USERNAME="admin"
ENV STRIPE_PUBLIC_KEY=pk_test_OIWeWKfTkuN2DuNcic60fqAi00CjwhKqQn
ENV STRIPE_SECRET_KEY=sk_test_zwmqSvEijuQvdykpEtrWJXaf00vbF0FLx8

COPY target/utopia-0.0.1-SNAPSHOT.jar .
COPY baeldung.p12 .

RUN echo $SPRING_DATASOURCE_URL

ENTRYPOINT java -jar utopia-0.0.1-SNAPSHOT.jar