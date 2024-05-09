ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.13.12"

lazy val root = (project in file("."))
  .settings(
    name := "Simple_kafka_zoo_single_doc"
  )
libraryDependencies += "org.apache.kafka" % "kafka-clients" % "3.4.0"