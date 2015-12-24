// Copyright (c) 2015 Ben Zimmer. All rights reserved.

// util-scala project build.sbt file

val whichJvmSettings = sys.props.getOrElse("jvm", default = "7")
val jvmSettings = whichJvmSettings match {
  case "6" => JvmSettings("1.6", "1.6", "1.6")
  case _ => JvmSettings("1.7", "1.7", "1.7")
}

lazy val root = (project in file("."))
  .settings(
    name := "util-scala",
    version := "2015.12.24",
    organization := "bdzimmer",
    scalaVersion := "2.10.6",

    javacOptions ++= Seq("-source", jvmSettings.javacSource, "-target", jvmSettings.javacTarget),
    scalacOptions ++= Seq(s"-target:jvm-${jvmSettings.scalacTarget}"),

    libraryDependencies ++= Seq("org.scalatest" %% "scalatest" % "2.2.4" % "it,test"),

    unmanagedSourceDirectories in Compile <<= (scalaSource in Compile)(Seq(_)),
    unmanagedSourceDirectories in Test <<= (scalaSource in Test)(Seq(_)))
  .configs(IntegrationTest)
  .settings(Defaults.itSettings: _*)

// import into Eclipse as a Scala project
EclipseKeys.projectFlavor := EclipseProjectFlavor.Scala

// use Java 1.7 in Eclipse
EclipseKeys.executionEnvironment := Some(EclipseExecutionEnvironment.JavaSE17)

// use the version of Scala from sbt in Eclipse
EclipseKeys.withBundledScalaContainers := false
