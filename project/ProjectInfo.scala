import sys.process._
import java.text.SimpleDateFormat
import java.util.{Date, Locale, TimeZone}

object ProjectInfo {
  private val dateTimeFormat = new SimpleDateFormat("dd.MM.yyyy H:mm:ss z", Locale.ENGLISH)
  dateTimeFormat.setTimeZone(TimeZone.getTimeZone("UTC"))

  val buildTime: String = dateTimeFormat.format(new Date)
  val commitFull: String = "git rev-parse HEAD".!!.trim
  val commitShort: String = "git rev-parse --short HEAD".!!.trim
  val commitMsg: String = "git log -1 --pretty=%B".!!.trim
}
