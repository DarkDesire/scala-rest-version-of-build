lazy val root = (project in file("."))
  .enablePlugins(BuildInfoPlugin)
  .settings(
    name := "scala-rest-version-of-build",
    version := "1.0.0",
    scalaVersion := "2.12.6",
    libraryDependencies := Dependencies.backend,
      buildInfoKeys := Seq[BuildInfoKey](
      name,
      version,
      "buildTime" -> ProjectInfo.buildTime,
      "commitMsg" -> ProjectInfo.commitMsg,
      "commitFull" -> ProjectInfo.commitFull,
      "commitShort" -> ProjectInfo.commitShort
    ),
    buildInfoOptions += BuildInfoOption.ToJson,
    buildInfoUsePackageAsPath := true
  )
