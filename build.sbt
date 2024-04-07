organization := "com.example"
scalaVersion := "2.12.18"

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

import ReleaseTransformations._

releaseVersionBump := sbtrelease.Version.Bump.Minor
releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,              // : ReleaseStep
  inquireVersions,                        // : ReleaseStep
  runClean,                               // : ReleaseStep
  runTest,                                // : ReleaseStep
  setReleaseVersion,                      // : ReleaseStep
  commitReleaseVersion,                   // : ReleaseStep, performs the initial git checks
  tagRelease,                             // : ReleaseStep
  //publishArtifacts,                       // : ReleaseStep, checks whether `publishTo` is properly set up
  setNextVersion,                         // : ReleaseStep
  commitNextVersion,                      // : ReleaseStep
  pushChanges                             // : ReleaseStep, also checks that an upstream branch is properly configured
)
