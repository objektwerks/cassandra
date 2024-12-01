name := "cassandra"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.6.2-RC3"
libraryDependencies ++= {
  val cassandraDriverVersion = "4.17.0"
  Seq(
    "com.datastax.oss" % "java-driver-core" % cassandraDriverVersion % Test,
    "com.datastax.oss" % "java-driver-query-builder" % cassandraDriverVersion % Test,
    "com.datastax.oss" % "java-driver-mapper-runtime" % cassandraDriverVersion % Test,
    "ch.qos.logback" % "logback-classic" % "1.5.12" % Test,
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wall"
)
