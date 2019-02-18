
/*Program for Fisher yates in Scala*/

import scala.util.Random

object fisherYates {
    def main(args: Array[String]) {
  var stringToShuffle: String = ("HEllO WORLD")
  //converting string to char array
  var str = stringToShuffle.toCharArray
  //execute with indices
  for(i <- str.indices)
  {
    //generating a random number
    val rand = Random.nextInt(str.length-1)
    //swapping
    val temp = str(i)
    str(i) = str(rand)
    str(rand) = temp
  }
  //displaying the shuffled string
  println("Shuffled String=>"+String.valueOf(str))
}
	}
