name := "cassandra"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "2.11.8"
ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }
libraryDependencies ++= {
  val cassandraVersion = "3.1.2"
  Seq(
    "com.datastax.cassandra" % "cassandra-driver-core" % cassandraVersion % "test",
    "com.datastax.cassandra" % "cassandra-driver-mapping" % cassandraVersion % "test",
    "ch.qos.logback" % "logback-classic" % "1.1.7" % "test",
    "org.scalatest" % "scalatest_2.11" % "3.0.1" % "test"
  )
}
scalacOptions ++= Seq(
  "-language:postfixOps",
  "-language:reflectiveCalls",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-feature",
  "-Ywarn-unused-import",
  "-Ywarn-unused",
  "-Ywarn-dead-code",
  "-unchecked",
  "-deprecation",
  "-Xfatal-warnings",
  "-Xlint:missing-interpolator",
  "-Xlint"
)
fork in test := true
javaOptions += "-server -Xss1m -Xmx2g"
