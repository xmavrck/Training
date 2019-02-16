import scala.util.Random
import scala.util.control.Breaks._

/*

@author akash

@readCase "print and println are used to customize the output screen"

*/

//This program will search for an element in array using Jump search or block search
object jumpSearch extends App {
//this method will search for element in array and returns its position otherwise returns -1(not found)
  def searchMethod(arrayElems: Array[Int], searchElem: Int): Int ={
    val n = arrayElems.length
    var step = Math.floor(Math.sqrt(n)).toInt
    var prev = 0
    var location = -1
    breakable{
      while(arrayElems(Math.min(step, n)-1) < searchElem){
        prev = step
        step += Math.floor(Math.sqrt(n)).toInt
        if(prev >= n) break
      }
      while(arrayElems(prev) < searchElem) {
        prev += 1
        if(prev == Math.min(step, n)) break
      }
    }
    if(arrayElems(prev) == searchElem) location = prev
    location
  }
  //user input to get size of array
  print("How many elements?")
  var arrayElems = Array.ofDim[Int](scala.io.StdIn.readInt())

  //generating random array elems
  for(i<-arrayElems.indices) arrayElems(i) = Random.nextInt(50)

  //sorting and printing array using insertion sort
  insertionSort.inSort(arrayElems)
  insertionSort.printArray(arrayElems)

  //user input for search element
  print("\nEnter Element to search=>")
  val searchElem = scala.io.StdIn.readInt()

  val pos = this.searchMethod(arrayElems, searchElem)

  //printing search results
  if(pos > -1) print("Element "+searchElem+" found at location "+ pos)
  else print("Element "+searchElem+" not found")
}
