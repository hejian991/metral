import Dependencies._
import ReleaseTransformations._

name := "metral"

organization := "com.growingio.metral"

scalaVersion := Versions.scala210

libraryDependencies ++= dependencies

//enablePlugins(ProtocPlugin)

releaseCrossBuild := true

releasePublishArtifactsAction := PgpKeys.publishSigned.value

releaseProcess := Seq[ReleaseStep](
  checkSnapshotDependencies,
  inquireVersions,
  runClean,
  runTest,
  setReleaseVersion,
  commitReleaseVersion,
  tagRelease,
  publishArtifacts,
  setNextVersion,
  commitNextVersion,
  pushChanges
)
