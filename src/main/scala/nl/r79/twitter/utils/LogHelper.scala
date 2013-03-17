package nl.r79.twitter.utils

import twitter4j._


import org.apache.log4j.Logger
import collection.mutable.ListBuffer


case object StartMessage

/**
 * LogHelper is a trait you can mix in to provide easy log4j logging
 * for your scala classes.
 **/
trait LogHelper {
  val loggerName = this.getClass.getName
  lazy val logger = Logger.getLogger(loggerName)
}

/**
 * Twitter stream example
 */
object Util extends LogHelper {

  var listBufferOfUsers = new ListBuffer[String]()

  val config = new twitter4j.conf.ConfigurationBuilder()
    .setOAuthConsumerKey("OB1Amia7UHTGdW6VeGCVtg")
    .setOAuthConsumerSecret("5ed9NUSRst2Ddt5fD9b5musvCqmh6kzCqn1PExgMMY")
    .setOAuthAccessToken("18424683-24w8rg1f9F44nfsfDKkaInXgJQKis8cQNq5nGM7bY")
    .setOAuthAccessTokenSecret("scS4hnGkbVhuqukhMBIalAWEtET737ysvGEvooDE")
    .build


  def directMessage() {

    val a = listBufferOfUsers.toList
    logger.info(a.foreach(e => println(e)))


  }

  def simpleStatusListener = new StatusListener() {
    def onStatus(status: Status) {
      logger.info(status.getUser().getScreenName() + " - " + status.getText());
      val item = (status.getUser().getScreenName())

      if (item != null) {
        listBufferOfUsers += item
        println(listBufferOfUsers.size)

      }

    }

    def onDeletionNotice(statusDeletionNotice: StatusDeletionNotice) {}

    def onTrackLimitationNotice(numberOfLimitedStatuses: Int) {}

    def onException(ex: Exception) {
      ex.printStackTrace
    }

    def onScrubGeo(arg0: Long, arg1: Long) {
    }

    def onStallWarning(warning: StallWarning) {}


  }


}






