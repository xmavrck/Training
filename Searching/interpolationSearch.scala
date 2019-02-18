import scala.util.Random
import scala.util.control.Breaks._
/*

@author akash

@readCase "print and println are used to customize the output screen"

*/

//following program will serach for an element using interpolation search
object interpolationSearch extends App {

  //runner method for search
  def searchInter(arr: Array[Int], searchEle: Int): Int ={
    var low = 0
    var high = arr.length-1
    var position = -1
    breakable {
      while (low <= high && searchEle >= arr(low) && searchEle <= arr(high)) {
        //updating position
        position = low + (((high - low) / (arr(high) - arr(low))) * (searchEle - arr(low)))
        if (arr(position) == searchEle)
          break //element found
        else { // updating positions
          if (arr(position) < searchEle) low = position + 1
          else high = position - 1
        }
      }
    }
    position //return position
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

  //calling function and retrieving position
  val pos = this.searchInter(arrayElems, searchElem)

  //printing search results
  if(pos > -1) print("Element "+searchElem+" found at location "+ pos)
  else print("Element "+searchElem+" not found")

}
