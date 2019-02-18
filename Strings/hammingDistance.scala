/*

@author akash

*/

//This program will calculate hamming distance between two strings
object hammingDistance extends App{

  //string one from user
  print("Enter String One=>")
  val stringOne:String = scala.io.StdIn.readLine()
  //string Two from user
  print("Enter String Two=>")
  val stringTwo:String = scala.io.StdIn.readLine()

  //if length of two strings isn't same then print error
  if(stringOne.length != stringTwo.length) println("Sequence of string is not equivalent!")
  //otherwise calculating hamming distance by comparing zip pair strings and putting count on it
  else println("Hamming Distance between '"+stringOne+"' and '"+stringTwo+"' is "+stringOne.zip(stringTwo).count(pair => pair._1 != pair._2))

}
