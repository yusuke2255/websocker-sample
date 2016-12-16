FROM java:8u102-jdk
WORKDIR /app
COPY ./build/libs/websocker-chat.jar /app/websocker-chat.jar
COPY ./websocket-chat.yml /app/websocket-chat.yml
CMD java -jar /app/websocker-chat.jar server /app/websocket-chat.yml