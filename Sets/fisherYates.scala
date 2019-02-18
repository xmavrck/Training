import scala.util.Random

/*

@author akash

*/

//Following program will genrate a random shuffle of permuted string by using Fisher Yates algorithms
object fisherYates extends App {
  //getting a string from user to shuffle
  print("Enter a String to shuffle=>")
  //converting string to char array
  var stringToShuffle = scala.io.StdIn.readLine().toCharArray
  for(i<-stringToShuffle.indices) {
    //generating random number to the size of string
    val rand = Random.nextInt(stringToShuffle.length-1)
    //swapping two numbers
    val temp = stringToShuffle(i)
    stringToShuffle(i) = stringToShuffle(rand)
    stringToShuffle(rand) = temp
  }
  //printing shuffled string
  println("Shuffled String=>"+String.valueOf(stringToShuffle))
}
