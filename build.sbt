organization := "com.example"
scalaVersion := "2.12.18"

ThisBuild / version := "1.0.0-SNAPSHOT"

lazy val root = (project in file("."))
  .aggregate(core, plugin)

lazy val commonSettings = Seq(
  libraryDependencies ++= Seq(
    "org.scala-lang" %% "toolkit" % "0.1.7",
    "org.scala-lang" %% "toolkit-test" % "0.1.7" % Test
  )
)

lazy val core = (project in file("core"))
  .settings(
    commonSettings,
    name := "example-core",
  ) 

lazy val plugin = (project in file("plugin"))
  .settings(
    commonSettings,
    name := "example-plugin",
  ) 
