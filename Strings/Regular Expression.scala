/*Progarm in Scala for Regular Expression Matching*/
import scala.util.matching.Regex
object Main {
	def main(args: Array[String])
	{
        val numPat: Regex = "[0-9]".r
        numPat.findFirstMatchIn("awesomepassword")
        //match cases for different situation
        match {
            case Some(_) => println("Password OK")
            case None => println("Password must contain a number")
        }
    }
}