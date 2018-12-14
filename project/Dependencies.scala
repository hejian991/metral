import sbt._

object Dependencies {

  object Versions {
    val guice = "4.2.2"
    val log4j2 = "11.0"
    val config = "1.3.3"
    val scala212 = "2.12.7"
    val scalatest = "3.0.5"
    val guava = "27.0-jre"
    val scala211 = "2.11.11"
    val scala210 = "2.10.7"
    val amqpClient = "5.5.0"
  }

  object Compiles {
    val config = "com.typesafe" % "config" % Versions.config
    val guava = "com.google.guava" % "guava" % Versions.guava
    val amqpClient = "com.rabbitmq" % "amqp-client" % Versions.amqpClient
    val log4j2 = "org.apache.logging.log4j" %% "log4j-api-scala" % Versions.log4j2
    val guice = "com.google.inject" % "guice" % Versions.guice exclude ("com.google.guava", "guava")
    val protobufShade = "com.github.os72" % "protobuf-java-shaded-360" % "0.9"
  }

  object Tests {
    val scalaTest: ModuleID = "org.scalatest" %% "scalatest" % Versions.scalatest % Test
  }

  import Compiles._

  lazy val dependencies: Seq[ModuleID] = Seq(protobufShade, config, guice, guava, log4j2, amqpClient, Tests.scalaTest)

}
