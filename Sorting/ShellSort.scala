
/*Program for Shell Sort in Scala*/

import scala.util.Random

object shellSort extends App {
    //function for sorting
  def sort(arr: Array[Int]): Unit =
  {
      //finding the array length
    var n = arr.length
    var gap = n/2
    while(gap > 0){
      for(i<-gap until n){
        val temp = arr(i)
        var j=i
        while(j>=gap && arr(j-gap)>temp) {
          arr(j) = arr(j-gap)
          j = j - gap
        }
       //updating the values
        arr(j) = temp
      }
      gap = gap / 2 
    }
  }
  def printArray(arrayElem: Array[Int]): Unit = 
  for(i<-arr.indices)
    println(arr(i)+"\t")
  //user input to get size of array
  print("Enter the number of elements\n")
  var arr = Array.ofDim[Int](scala.io.StdIn.readInt())

  //generating the random elements in the array
  for(i<-arr.indices) arr(i) = Random.nextInt(100)
  
  //displaying the output
  print("Elements Before Sorting are : \n")
  printArray(arr)
  print("\nElements After Sorting are : \n")
  this.sort(arr)
  
  //calling the function
  printArray(arr)

}