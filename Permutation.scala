//Following program in Scala will calculate all Permutations with and without repetition

object Permutation extends App{
  //swapTwo will swap two characters in string
  //1. Converts string to a char array
  //2. swap to characters in array
  //3. returns value as String
  def swapTwo(permuteString: String, char1: Int, char2: Int): String = {
    var string = permuteString.toCharArray
    val temp = string(char1)
    string(char1) = string(char2)
    string(char2) = temp
    String.valueOf(string)
  }

  //permutationWithoutRepetition will find all permutations without repetitions
  //1. it will print string of current low and max of string is exactly at same location
  //2. otherwise, it will loop through from low to max and firstly it will swap two elements
  //3. then, recursive call will low + 1
  //4. Again Swapping two elements
  def permutationWithoutRepetition(permuteString: String, low: Int, max: Int): Unit ={
    var permuteStringIn: String = permuteString
    if(low == max) println(permuteStringIn)
    else{
      for (i <- low to max) {
        permuteStringIn = swapTwo(permuteStringIn, low, i)
        permutationWithoutRepetition(permuteStringIn, low + 1, max)
        permuteStringIn = swapTwo(permuteStringIn, low, i)
      }
    }
  }

  //this will print all permutations by following backtracking and prefixing
  def permutationWithRepetition(permuteString: Array[Char], prefix: String, low: Int, max: Int): Unit ={
    if(max == 0) println(prefix)
    else{
      for(i<-0 until low){
        var newString = prefix+permuteString(i)
        permutationWithRepetition(permuteString, newString, low, max-1)
      }
    }
  }

  //will calculate possible permutations without repetition, ******n!******
  def numberOfPermutation(n: Int): Int = n match {
    case 0 => 1
    case _ => n * numberOfPermutation(n-1)
  }

  print("Enter String:")
  var stringForPermutation = scala.io.StdIn.readLine()
  print("Is Repetition Allowed?y=>Yes,n=>No: ")
  var repFlag = scala.io.StdIn.readChar()
  if(repFlag == 'n') {
    permutationWithoutRepetition(stringForPermutation, 0, stringForPermutation.length-1)
    println("Total Number of Permutations: "+numberOfPermutation(stringForPermutation.length))
  }
  else if(repFlag == 'y'){
    permutationWithRepetition(stringForPermutation.toCharArray, "", stringForPermutation.length, stringForPermutation.length)
    println("Total Number of Permutations: "+Math.pow(stringForPermutation.length, stringForPermutation.length).toInt)
  }
}
