FROM openjdk:8-jdk

#install git
RUN apt-get update && apt-get install -y git netcat
RUN git clone https://github.com/alissonte/magacomunication.git

#install gradle
RUN wget https://downloads.gradle-dn.com/distributions/gradle-6.5-bin.zip
RUN unzip gradle-6.5-bin.zip
ENV GRADLE_HOME /gradle-6.5
ENV PATH $PATH:/gradle-6.5/bin

#compile and run app
WORKDIR magacomunication
RUN chmod a+x init.sh
RUN gradle build -x test --no-build-cache -p ./app
ENTRYPOINT ["./init.sh"]
