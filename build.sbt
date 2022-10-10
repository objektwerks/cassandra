name := "cassandra"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.13.10"
libraryDependencies ++= {
  val cassandraDriverVersion = "4.14.1"
  Seq(
    "com.datastax.oss" % "java-driver-core" % cassandraDriverVersion % Test,
    "com.datastax.oss" % "java-driver-query-builder" % cassandraDriverVersion % Test,
    "com.datastax.oss" % "java-driver-mapper-runtime" % cassandraDriverVersion % Test,
    "ch.qos.logback" % "logback-classic" % "1.4.3" % Test,
    "org.scalatest" %% "scalatest" % "3.2.14" % Test
  )
}
