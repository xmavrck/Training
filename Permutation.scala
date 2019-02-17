
/*Program for finding the permutation with and without repetition*/

object Permutation extends App{
//For swapping two characters in a string
  def swapTwo(str: String, n1: Int, n2: Int): String = {
    var string = str.toCharArray
    val temp = string(n1)
    string(n1) = string(n2)
    string(n2) = temp
    String.valueOf(string)
  }
//for Permutation without tepetition
  def PWOR(str: String, low: Int, max: Int): Unit ={
    var permuteStringIn: String = str
    if(low == max) println(permuteStringIn)
    else{
      for (i <- low to max) {
        permuteStringIn = swapTwo(permuteStringIn, low, i)
        PWOR(permuteStringIn, low + 1, max)
        permuteStringIn = swapTwo(permuteStringIn, low, i)
      }
    }
  }

  //for permutation with reporting
  def PWR(permuteString: Array[Char], prefix: String, low: Int, max: Int): Unit ={
    if(max == 0) println(prefix)
    else{
      for(i<-0 until low){
        var newString = prefix+permuteString(i)
        PWR(permuteString, newString, low, max-1)
      }
    }
  }

//for calculating permutation
  def numberOfPermutation(n: Int): Int = n match {
      //Multiple cases
    case 0 => 1
    case _ => n * numberOfPermutation(n-1)
  }
//entering the string for finding the permutation
  var str1 = "hello"
  //giving whether permutation is allowed or not
  var repFlag = 'n'
  if(repFlag == 'n') 
  {
    PWOR(str1, 0, str1.length-1)
    println("Total Number of Permutations: "+numberOfPermutation(str1.length))
  }
  else if(repFlag == 'y')
  {
    PWR(str1.toCharArray, "", str1.length, str1.length)
    println("Total Number of Permutations: "+Math.pow(str1.length, str1.length).toInt)
  }
}