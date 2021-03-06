val appName = "play-yeoman"
val appVersion = "0.9.0"

val main = Project(appName, file(".")).enablePlugins(PlayScala).settings(
  version := appVersion,
  scalaVersion in Global := "2.11.7",
  //    crossScalaVersions := Seq("2.11.7"),
  homepage := Some(url("https://github.com/tuplejump/play-yeoman")),
  organization := "com.tuplejump",
  organizationName := "Tuplejump Software Pvt. Ltd.",
  organizationHomepage := Some(new java.net.URL("http://www.tuplejump.com")),
  licenses := Seq("Apache License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0")),
  publishMavenStyle := true,
  publishTo <<= version {
    (v: String) =>
      val nexus = "https://oss.sonatype.org/"
      if (v.trim.endsWith("SNAPSHOT"))
        Some("snapshots" at nexus + "content/repositories/snapshots")
      else
        Some("releases" at nexus + "service/local/staging/deploy/maven2")
  },
  publishArtifact in Test := false,
  pomIncludeRepository := {
    _ => false
  },
  pomExtra := (
    <scm>
      <url>git@github.com:tuplejump/play-yeoman.git</url>
      <connection>scm:git:git@github.com:tuplejump/play-yeoman.git</connection>
    </scm>
      <developers>
        <developer>
          <id>eraoferrors</id>
          <name>Shiti Saxena</name>
          <url>https://twitter.com/eraoferrors</url>
        </developer>
        <developer>
          <id>milliondreams</id>
          <name>Rohit Rai</name>
          <url>https://twitter.com/milliondreams</url>
        </developer>
      </developers>)
)