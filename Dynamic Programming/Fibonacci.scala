/*

@author akash on 15/2/19 1:55 PM

*/

//This program will print fibonacci series upto a number of series
object Fibonacci extends App{
  //setting max user input to 50
  val maxInput = 50
  //getting input of series count from user
  println("Enter Series count:")
  var numberSer = scala.io.StdIn.readInt()
  if(numberSer > 50) numberSer = maxInput
  //setting first two elements
  var currentEle = 1
  var previousEle = 0
  //if inpt from user is one then print 0 only
  if(numberSer == 1) print(0)
    //otherwise print upto user input
  else {
    print(previousEle + "\t" + currentEle + "\t")
    var counter = 2 //setting counter to 2 as first two elements are already defined
    //looping until user input
    while (counter < numberSer) {
      //changing current element by adding previous element and current element to it
      currentEle += previousEle
      //calculating previous element by subtracting  it from current Element
      previousEle = currentEle - previousEle
      //counting until user input
      counter += 1
      //printing current element
      print(currentEle + "\t")
    }
  }
}
