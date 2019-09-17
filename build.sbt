name := "hello-akka-typed-scala"

version := "1.0"

crossScalaVersions := Seq("2.13.0", "2.12.9")
scalaVersion := crossScalaVersions.value.head

lazy val akkaVersion = sys.props.getOrElse("akka.version", "2.6.0-M7")

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "ch.qos.logback" % "logback-classic" % "1.2.3"
)
