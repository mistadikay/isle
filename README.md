# Introduction to Scala Language and Ecosystem assignment

### Build

```sbtshell
sbt package
```

### Run 

Regular healthcheck:
```sbtshell
scala ./target/scala-2.12/isle_2.12-0.1.jar --frequency 100 --type healthcheck
```

File healthcheck:
```sbtshell
scala ./target/scala-2.12/isle_2.12-0.1.jar --frequency 100 --type filecheck --location /path/to/file.txt
```
