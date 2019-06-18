name := "cassandra"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.12.8"
libraryDependencies ++= {
  val cassandraDriverVersion = "4.0.1"
  Seq(
    "com.datastax.oss" % "java-driver-core" % cassandraDriverVersion % "test",
    "com.datastax.oss" % "java-driver-query-builder" % cassandraDriverVersion % "test",
    "ch.qos.logback" % "logback-classic" % "1.2.3" % "test",
    "org.scalatest" %% "scalatest" % "3.0.5" % "test"
  )
}