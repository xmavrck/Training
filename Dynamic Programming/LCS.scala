/*

@author akash

@readCase "print and println are used to customize the output screen"

*/

//Following program will calculate longest common subsequence using Dynamic programming approach
object LCS extends App {

  //runner method
  def lcs(arrayOne: Array[Char], arrayTwo: Array[Char]): Int ={
    val n = arrayOne.length //array one length
    val m = arrayTwo.length //array two length
    var newArray = Array.ofDim[Int](n+1, m+1) //new two dimensional array for Dynamic programming
    for(i<-0 to n) for(j<-0 to m){
      if(i == 0 || j == 0) newArray(i)(j) = 0 //first row and column to 0
      else if (arrayOne(i-1) == arrayTwo(j-1)) newArray(i)(j) = newArray(i-1)(j-1) + 1 //updaing newArray values
      else newArray(i)(j) = max(newArray(i-1)(j), newArray(i)(j-1))
    }
    newArray(n)(m) //returning max sequences count
  }

  //this method will return maximum of two values
  def max(a: Int, b: Int): Int = if(a > b) a else b

  //getting user input for two strings
  print("Enter String 1=>")
  var stringOne = scala.io.StdIn.readLine().toCharArray
  print("Enter String 2=>")
  var stringTwo = scala.io.StdIn.readLine().toCharArray
  //printing and calling runner method for output
  print("Longest common subsequence count is => "+this.lcs(stringOne, stringTwo))
}
