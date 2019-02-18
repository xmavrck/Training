import scala.util.Random

/*

@author akash

*/

  //This program will search for an element in array of size n using linear search method
object linearSearch extends App {
    //getting user input of elements count
  println("How many elements? ")
  val countOfElements = scala.io.StdIn.readInt()
  //declaring array size to user input
  var arrayOfElems = Array.ofDim[Int](countOfElements)
    //generating random elements upto 100
  for(i<-0 until countOfElements) arrayOfElems(i) = Random.nextInt(100)
    //printing array
  for(z<-arrayOfElems.indices) print(arrayOfElems(z)+" ")
    //getting user input to search an element
  println("\nEnter element to search=>")
  val searchElement = scala.io.StdIn.readInt()
    //setting element search position to -1 (not found)
  var position = -1
    //seraching element and updating position variable
  for(x<-arrayOfElems.indices) if (arrayOfElems(x) == searchElement) position = x
    //printing position of searched element otherwise not found
  if (position > -1) println("Element "+searchElement+" found at "+position+" position")
  else println("Element "+searchElement+" not found!")
}
