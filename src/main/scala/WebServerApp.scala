import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.io.StdIn
object WebServerApp extends App {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  // needed for the future flatMap/onComplete in the end
  implicit val executionContext = system.dispatcher
  val route =
    path("version") {
      get {
        complete(HttpEntity(ContentTypes.`application/json`, buildinfo.BuildInfo.toJson))
      }
    }

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

  print("Server online at http://localhost:8080/\n"+
    "Version of build here: http://localhost:8080/version\n"+
    "Press RETURN to stop...")
  StdIn.readLine() // let it run until user presses return
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ => system.terminate()) // and shutdown when done
}
