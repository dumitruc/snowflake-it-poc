import sbt.*

object Dependencies {

  private object Versions {
    val scalaVersion = "2.12.5"
    val sparkVersion = "3.4.1"
    val sparkSnowflakeVersion = "2.12.0-spark_3.4"
    val scalaMajorVersion: String =
      scalaVersion.split("\\.").take(2).mkString(".")

    val scalaTestVersion = "3.2.12"
    val scalaCheckVersion = "1.17.0"
    val scalaTestPlusVersion = "3.2.11.0"

    val mockitoVersion = "1.17.12"
    val localStackVersion = "0.2.21"
    val awaitilityVersion = "4.2.0"
    val wiremockVersion = "2.34.0"
    val testContainersVersion = "1.17.3"
    val logBackVersion = "1.4.1"

    val awsJavaSdkVersion = "1.12.273"

  }

  import Versions._

  val logging = Seq(
    "ch.qos.logback" % "logback-classic" % logBackVersion,
  )

  val aws = Seq(
    "com.amazonaws" % "aws-java-sdk-s3" % awsJavaSdkVersion,
  )

  val sparkDependencies = Seq(
    "org.apache.spark" %% "spark-core" % sparkVersion,
    "org.apache.spark" %% "spark-sql" % sparkVersion,
    // "com.snowflake" % "snowpark" % "1.4.1",
    "net.snowflake" %% "spark-snowflake"  % sparkSnowflakeVersion
  )



  val testDependencies = Seq(
    "org.scalatest" %% "scalatest" % scalaTestVersion % "it,test",
    "org.mockito" %% "mockito-scala-scalatest" % mockitoVersion % "it,test",
    "cloud.localstack" % "localstack-utils" % localStackVersion % "it,test",
    "org.scalacheck" %% "scalacheck" % scalaCheckVersion % "it,test",
    "org.scalatestplus" %% "scalacheck-1-15" % scalaTestPlusVersion % "it,test",
    "org.awaitility" % "awaitility-scala" % awaitilityVersion % "it,test",
    "com.github.tomakehurst" % "wiremock-jre8" % wiremockVersion % "it,test",
    "org.testcontainers" % "testcontainers" % testContainersVersion % "it,test",
    "org.testcontainers" % "localstack" % testContainersVersion % "it,test"
  )

}
