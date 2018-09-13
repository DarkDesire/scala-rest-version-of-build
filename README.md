Simple project - example of getting build info through REST.

Used these libraries:
- Akka-actor, akka-streams, akka-http - **for REST service**.

Used these plugins:
- sbt-buildinfo - **for build information**. (Read more here: https://github.com/sbt/sbt-buildinfo)

Before start, make sure that you compiled the code. (hint:`sbt compile`).

Start server and open in browser page: http://localhost:8080/version and you will get information about last commit and version of build.
Something close to this, but not pretty formated: 
```
{
  "name": "scala-rest-version-of-build",
  "commitMsg": "Third commit. CommitMsg is trimmed!",
  "buildTime": "13.09.2018 22:16:09 UTC",
  "version": "1.0.0",
  "commitShort": "afa2909",
  "commitFull": "afa29097c6c0e2dc6553a667231d2c0becee3170"
}
```
