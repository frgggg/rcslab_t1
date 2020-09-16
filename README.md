# rcslab_t1

1) Install:
1.1) need gradle 4.10 +
1.2) tested on gradle-6.4.1
1.3) build:
# gradle bootJar

2) Exec examples:
2.1) X - port, Y - "jdbc:sqlite:" + path to data.sqlite + "/data.sqlite"
java \
    -Dspring.profiles.active=dev \
    -Dserver.port=X \
    -Dsqlite.path=Y \
    -jar ./build/libs/InTest-1.1.jar

2.2) X - port, Y - path to data.sqlite
export RCSLAB_T1_PORT=X
export RCSLAB_T1_DB_PATH=Y
java \
    -Dspring.profiles.active=dev \
    -jar ./build/libs/InTest-1.1.jar
    
3) Use
3.1) X - port, Y - path to data.sqlite
3.2) Args: row, col. All must exist.
3.2) Example
http://localhost:X/?row=Y&col=Z
