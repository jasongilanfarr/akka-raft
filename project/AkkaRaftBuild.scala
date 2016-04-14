import com.typesafe.sbt.SbtGit.git
import com.typesafe.sbt.{GitBranchPrompt, GitPlugin, GitVersioning}
import sbt._
import sbt.Keys._
import Dependencies._

object AkkaRaftBuild extends Build {
  lazy val root = Project("akka-raft", file("."))
    .enablePlugins(GitVersioning, GitBranchPrompt)
    .settings(
      name := "akka-raft",
      scalaVersion := "2.11.8",
      incOptions <<= incOptions.map(_.withNameHashing(true)),
      javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint"),
      scalacOptions := Seq("-deprecation", "-unchecked", "-target:jvm-1.8",
        "-Ybackend:GenBCode", "-feature", "-Xexperimental", "-Xlint", "-Xfatal-warnings", "-Xfuture",
        "-Yclosure-elim"),
      updateOptions := updateOptions.value.withCachedResolution(true),
      git.useGitDescribe := true,
      libraryDependencies ++= Akka.defaults ++ General.defaults ++ Logging.defaults ++ Testing.defaults
    )
}