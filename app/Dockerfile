FROM openjdk:8-jdk
#install git
RUN apt-get install -y git
RUN git clone https://github.com/alissonte/magacomunication.git
#install gradle
RUN wget https://downloads.gradle-dn.com/distributions/gradle-6.5-bin.zip
RUN unzip gradle-6.5-bin.zip
ENV GRADLE_HOME /gradle-6.5
ENV PATH $PATH:/gradle-6.5/bin
#compile and run app
WORKDIR magacomunication
RUN gradle build --no-build-cache
# ENTRYPOINT ["java", "-jar", "build/libs/maga.jar"]