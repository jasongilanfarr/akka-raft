import sbt._

object Dependencies {

  object Akka {
    private val version = "2.4.3"
    val actor = "com.typesafe.akka" %% "akka-actor" % version
    val cluster = "com.typesafe.akka" %% "akka-cluster" % version
    val httpCore = "com.typesafe.akka" %% "akka-http-core" % version
    val http = "com.typesafe.akka" %% "akka-http-experimental" % version
    val persistence = "com.typesafe.akka" %% "akka-persistence" % version
    val remote = "com.typesafe.akka" %% "akka-remote" % version
    val slf4j = "com.typesafe.akka" %% "akka-slf4j" % version
    val streams = "com.typesafe.akka" %% "akka-stream" % version
    val sprayJson = "com.typesafe.akka" %% "akka-http-spray-json-experimental" % version
    val sprayJsonShapeless = "com.github.fommil" %% "spray-json-shapeless" % "1.2.0"

    val testKit = "com.typesafe.akka" %% "akka-testkit" % version
    val httpTestKit = "com.typesafe.akka" %% "akka-http-testkit" % version
    val multiNodeTestKit = "com.typesafe.akka" %% "akka-multi-node-testkit" % version

    val defaults = Seq(actor, cluster, httpCore, http, persistence, remote, slf4j, streams, sprayJson,
      sprayJsonShapeless, testKit % "test", httpTestKit % "test", multiNodeTestKit % "test")
  }

  object General {
    val java8Compat = "org.scala-lang.modules" % "scala-java8-compat_2.11" % "0.8.0-RC1"
    val kamonCore =   "io.kamon" %% "kamon-core" % "0.6.0"
    val defaults = Seq(java8Compat)
  }

  object Logging {
    private val version = "1.7.21"
    val slf4j = "org.slf4j" % "slf4j-api" % version
    val logback = "ch.qos.logback" % "logback-classic" % "1.1.7"

    val defaults = Seq(slf4j, logback)
  }

  object Testing {
    val scalatest = "org.scalatest" % "scalatest_2.11" % "2.2.6"
    val defaults = Seq(scalatest % "test")
  }
}