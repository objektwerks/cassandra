name := "cassandra"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.5"
libraryDependencies ++= {
  val cassandraDriverVersion = "4.11.0"
  Seq(
    "com.datastax.oss" % "java-driver-core" % cassandraDriverVersion % Test,
    "com.datastax.oss" % "java-driver-query-builder" % cassandraDriverVersion % Test,
    "com.datastax.oss" % "java-driver-mapper-runtime" % cassandraDriverVersion % Test,
    "ch.qos.logback" % "logback-classic" % "1.2.3" % Test,
    "org.scalatest" %% "scalatest" % "3.2.9" % Test
  )
}
