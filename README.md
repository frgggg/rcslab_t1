# rcslab_t1

1) Install:
1.1) need gradle 4.10 +
1.2) tested on gradle-6.4.1
1.3) build:
# gradle bootJar

2) Exec examples:
2.1) X - port, Y - "jdbc:sqlite:" + path to data.sqlite + "/data.sqlite"
# java \
    -Dspring.profiles.active=dev \
    -Dserver.port=X \
    -Dsqlite.path=Y \
    -jar ./build/libs/InTest-1.1.jar

2.2) X - port, Y - path to data.sqlite
#export RCSLAB_T1_PORT=X
#export RCSLAB_T1_DB_PATH=Y
# java \
    -Dspring.profiles.active=dev \
    -jar ./build/libs/InTest-1.1.jar

2.3) X - port, Y - "jdbc:sqlite:" + path to data.sqlite + "/data.sqlite"
# java \
    -Dserver.port=X \
    -Dsqlite.path=Y \
    -jar ./build/libs/InTest-1.1.jar
2.4) X - port, Y - docker image name
#export RCSLAB_T1_PORT=X
#docker build -tY ./
#docker run -p8070:${RCSLAB_T1_PORT} -eRCSLAB_T1_PORT=${RCSLAB_T1_PORT} -d Y

3) Use
3.1) X - port, Y - row val, Z - col val. Y and Z can be one of {a, b, c, d, y, v};
3.2) Args: row, col. All must exist;
3.2) Example:
http://localhost:X/?row=Y&col=Z
