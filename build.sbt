name := "cassandra"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.12.8"
libraryDependencies ++= {
  val cassandraDriverVersion = "4.1.0"
  Seq(
    "com.datastax.oss" % "java-driver-core" % cassandraDriverVersion % Test,
    "com.datastax.oss" % "java-driver-query-builder" % cassandraDriverVersion % Test,
    "ch.qos.logback" % "logback-classic" % "1.2.3" % Test,
    "org.scalatest" %% "scalatest" % "3.0.8" % Test
  )
}