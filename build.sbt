organization := "com.example"
scalaVersion := "2.12.18"

ThisBuild / version := "1.0.0-SNAPSHOT"

lazy val core = project.settings(
  name := "example-core",
  libraryDependencies ++= Seq(
    "org.scala-lang" %% "toolkit" % "0.1.7",
    "org.scala-lang" %% "toolkit-test" % "0.1.7" % Test
  )
)

lazy val plugin = project.settings(
  name := "example-plugin",
  libraryDependencies ++= Seq(
    "org.scala-lang" %% "toolkit" % "0.1.7",
    "org.scala-lang" %% "toolkit-test" % "0.1.7" % Test
  )
)
