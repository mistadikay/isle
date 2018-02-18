# Introduction to Scala Language and Ecosystem assignment

### Build

```sbtshell
sbt clean assembly
```

### Run 

Heartbeat mode:
```sbtshell
java -jar target/scala-2.12/agent.jar --frequency 100 --type heartbeat
```

File healthcheck:
```sbtshell
java -jar target/scala-2.12/agent.jar --frequency 100 --type filecheck --location /path/to/file.txt
```
