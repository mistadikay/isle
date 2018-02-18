import Dependencies._

lazy val root = Project(id = "agent", file("."))
    .settings(
        inThisBuild(List(
            organization := "com.mistadikay",
            scalaVersion := "2.12.4",
            version      := "0.2.0"
        )),
        name := "agent",
        libraryDependencies += scalaTest % Test,
        mainClass in assembly := Some("com.mistadikay.isle.agent.Agent"),
        assemblyJarName in assembly := "agent.jar"
    )