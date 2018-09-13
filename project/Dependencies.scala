import sbt._
object Dependencies {
  // Versions
  lazy val akkaVerison = "2.5.16"
  lazy val akkaHttpVersion = "10.1.5"
  // Libraries
  lazy val akkaActors = "com.typesafe.akka" %% "akka-actor" % akkaVerison
  lazy val akkaStreams = "com.typesafe.akka" %% "akka-stream" % akkaVerison
  lazy val akkaHttp = "com.typesafe.akka" %% "akka-http" % akkaHttpVersion
  // Dependencies
  lazy val backend = Seq(akkaActors,akkaStreams,akkaHttp)
}