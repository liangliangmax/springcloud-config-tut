FROM java:8u111-jre-alpine
ENV LANG C.UTF-8
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
VOLUME /tmp
# 从以下位置读取日志的配置文件
RUN mkdir -p /usr/local/neuabc/profile/logback/common-microservice
# 将产生的日志写到这个目录下
RUN mkdir -p /usr/local/neuabc/log/common-microservice
ADD eureka.jar app.jar
ENTRYPOINT java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar /app.jar