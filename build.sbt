name := "objektwerks.cassandra"
version := "1.0"
scalaVersion := "2.11.7"
ivyScala := ivyScala.value map { _.copy(overrideScalaVersion = true) }
libraryDependencies ++= {
  val cassandraVersion = "1.12.2"
  Seq(
    "com.websudos" % "phantom-connectors_2.11" % cassandraVersion,
    "com.websudos" % "phantom-dsl_2.11" % cassandraVersion,
    "com.websudos" % "phantom-testkit_2.11" % cassandraVersion % test,
    "ch.qos.logback" % "logback-classic" % "1.1.3",
    "org.scalatest" % "scalatest_2.11" % "2.2.5" % "test"
  )
}
scalacOptions ++= Seq(
  "-language:postfixOps",
  "-language:implicitConversions",
  "-language:reflectiveCalls",
  "-language:higherKinds",
  "-feature",
  "-unchecked",
  "-deprecation",
  "-Xlint",
  "-Xfatal-warnings"
)
fork in test := true
javaOptions += "-server -Xss1m -Xmx2g"
logLevel := Level.Info
