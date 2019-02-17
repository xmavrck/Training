
/*Progarm in Scala for LCS*/

object LCS extends App {
    //For finding LCS
  def lcs(arr1: Array[Char], arr2: Array[Char]): Int ={
      //Calculating the length of the arrays
    val n = arr1.length
    val m = arr2.length
    //New array
    var arr = Array.ofDim[Int](n+1, m+1)
    for(i<-0 to n) for(j<-0 to m)
    {
      if(i == 0 || j == 0)
        arr(i)(j) = 0 //first row and column to 0
      else if (arr1(i-1) == arr2(j-1))
        arr(i)(j) = arr(i-1)(j-1) + 1 //updaing newArray values
      else
      {
        arr(i)(j) = max(arr(i-1)(j)
        arr(i)(j-1))
      }
    }
    //returning the max value
    arr(n)(m)
  }

  //this method will return maximum of two values
  def max(a: Int, b: Int): Int = {
      if(a > b)
        return a
      else
        return b
}
    //initializing both the strings
    var str1 = "Hello"
    var string1 = str1.toCharArray
    var str2 = "Everyone"
    var string2 = str2.toCharArray
    
    //printing and calling runner method for output
    print("Longest common subsequence is: "+this.lcs(string1, string2))
}