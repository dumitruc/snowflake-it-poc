import sbt.{Test, Tests}

scalaVersion := "2.13.12"

organization := "dumitruc.poc"
version := "0.1.0-SNAPSHOT"

libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "2.3.0"

lazy val commonSettings = Seq(
  libraryDependencies ++= Dependencies.sparkDependencies ,
  libraryDependencies ++= Dependencies.logging,
  libraryDependencies ++= Dependencies.aws,
  run / fork := true,
  run / connectInput := true,
  run / outputStrategy := Some(StdoutOutput),
)

lazy val app = (project in file("app"))
  .settings(name := "snowflake-it-poc", commonSettings)

lazy val it = (project in file("it"))
  .dependsOn(app % "test->test;compile->compile")
  .settings(commonSettings,
    Test / testOptions += Tests.Argument(TestFrameworks.ScalaTest, "-oDF")
  )
  .settings(
    libraryDependencies ++= Dependencies.testDependencies
  )
