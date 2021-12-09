import scala.concurrent.duration._

organization := "com.codecommit"
version := "0.0.1"

ThisBuild / crossScalaVersions := Seq("2.13.6", "2.12.15")
ThisBuild / scalaVersion := crossScalaVersions.value.head

ThisBuild / githubWorkflowTargetTags += "v*"

ThisBuild / githubWorkflowJavaVersions += JavaSpec.graalvm("21.1.0", "8")
ThisBuild / githubWorkflowPublishTargetBranches += RefPredicate.Equals(Ref.Tag("test"))

ThisBuild / githubWorkflowBuildMatrixAdditions += "test" -> List("this", "is")

ThisBuild / githubWorkflowBuildMatrixInclusions += MatrixInclude(
  Map("test" -> "this"),
  Map("extra" -> "sparta"))

ThisBuild / githubWorkflowBuildMatrixExclusions +=
  MatrixExclude(Map("scala" -> "2.12.15", "test" -> "is"))

ThisBuild / githubWorkflowBuild += WorkflowStep.Run(List("echo yo"))
ThisBuild / githubWorkflowBuildTimeout := Some(2.hours)

ThisBuild / githubWorkflowPublish += WorkflowStep.Run(List("echo sup"))
ThisBuild / githubWorkflowPublishTimeout := Some(1.hour)
