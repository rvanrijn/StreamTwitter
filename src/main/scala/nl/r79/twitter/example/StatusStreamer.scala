package nl.r79.twitter.example

import nl.r79.twitter.utils.{LogHelper, Util}
import twitter4j._
import auth.AccessToken
import akka.actor.{ActorRef, Props, ActorSystem, Actor}


case object StartMessage
case object StopMessage


trait TwitterInstance {
  val twitter = new TwitterFactory().getInstance
  // Authorising with your Twitter Application credentials
  twitter.setOAuthConsumer("xxx",
    "xxx")
  twitter.setOAuthAccessToken(new AccessToken(
    "xxx",
    "xxx"))
}


object StatusStreamer extends TwitterInstance with LogHelper {

  def main(args: Array[String]) {

    val system = ActorSystem("TwitterStreamSystem")
    val pong = system.actorOf(Props[Pong], name = "pong")
    val ping = system.actorOf(Props(new Ping(pong)), name = "ping")


    val twitterStream = new TwitterStreamFactory(Util.config).getInstance
    twitterStream.addListener(Util.simpleStatusListener)
    twitterStream.filter(new FilterQuery().track(args))
    Thread.sleep(10000)

    ping ! StartMessage
    ping ! StartMessage
    twitterStream.shutdown

    Util.directMessage()

  }

  class Ping(pong: ActorRef) extends Actor {
    var count = 0
    def incrementAndPrint { count += 1; println("ping") }
    def receive = {
      case StartMessage =>
        println("wh000000t")
        pong ! StopMessage
    }
  }

  class Pong extends Actor {
    def receive = {
      case StopMessage =>
        println("pong stopped")
        context.stop(self)
    }
  }

}






