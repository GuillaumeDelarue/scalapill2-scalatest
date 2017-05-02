name := "scalapill2-scalatest"

version := "1.0"

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "3.0.1",
  "org.mockito" % "mockito-all" % "1.10.19",
  "org.seleniumhq.selenium" % "selenium-java" % "2.35.0" % "test"
)
