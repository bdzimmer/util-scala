// Copyright (c) 2015 Ben Zimmer. All rights reserved.

// util-scala project build.sbt file

val jvmSettings = JvmSettings("1.8", "1.8", "1.8")

lazy val root = (project in file("."))
  .settings(
    name := "util-scala",
    version := "2015.12.24",
    organization := "bdzimmer",
    scalaVersion := "2.10.6",

    javacOptions ++= Seq("-source", jvmSettings.javacSource, "-target", jvmSettings.javacTarget),
    scalacOptions ++= Seq(s"-target:jvm-1.7"),

    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4"),

    unmanagedSourceDirectories in Compile <<= (scalaSource in Compile)(Seq(_)),
    unmanagedSourceDirectories in Test <<= (scalaSource in Test)(Seq(_)))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)

// import into Eclipse as a Scala project
EclipseKeys.projectFlavor := EclipseProjectFlavor.Scala

// use Java 1.8 in Eclipse
EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE18)

// use the version of Scala from sbt in Eclipse
EclipseKeys.withBundledScalaContainers := false
