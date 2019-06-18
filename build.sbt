name := "cassandra"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.12.8"
libraryDependencies ++= {
  Seq(
    "com.datastax.cassandra" % "cassandra-driver-core" % "4.0.0" % "test",
    "com.datastax.cassandra" % "cassandra-driver-mapping" % "3.7.1" % "test",
    "ch.qos.logback" % "logback-classic" % "1.2.3" % "test",
    "org.scalatest" %% "scalatest" % "3.0.5" % "test"
  )
}