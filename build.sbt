name := "twitter4j-tutorial"

version := "0.1.0"

scalaVersion := "2.9.2"

resolvers += "Akka Repository" at "http://repo.akka.io/releases"

libraryDependencies ++= Seq("com.typesafe.akka" % "akka-actor" % "2.0.4")

libraryDependencies += "org.twitter4j" % "twitter4j-stream" % "3.0.3"

libraryDependencies += "org.scalaz" % "scalaz-core_2.9.2" % "6.0.4"

libraryDependencies += "org.skife.com.typesafe.config" % "typesafe-config" % "0.3.0"

libraryDependencies += "org.slf4j" % "slf4j-log4j12" % "1.7.2"

libraryDependencies += "log4j" % "log4j" % "1.2.15" excludeAll(
                                                        ExclusionRule(organization = "com.sun.jdmk"),
                                                        ExclusionRule(organization = "com.sun.jmx"),
                                                        ExclusionRule(organization = "javax.jms")
                                                      )