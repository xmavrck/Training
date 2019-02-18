import scala.util.Random
/*

@author akash

*/
//Following program will sort the elements in array using insertion sort method
object insertionSort extends App {
  //method will sort the array elements
  def inSort(arrayToSort: Array[Int]): Unit ={
    //looping through all elements in array
    for(x<-1 until arrayToSort.length){
      //storing current element
      var key = arrayToSort(x)
      //another variable to compare values
      var j=x-1
      //changing element until jth element is greater than key
      while(j>=0 && arrayToSort(j) > key){
        arrayToSort(j+1) = arrayToSort(j)
        j-=1
      }
      //updating next element with key value
      arrayToSort(j+1)=key
    }
  }
  //this method will print the array
  def printArray(arrayPrint: Array[Int]): Unit = for(i<-arrayPrint.indices) print(arrayPrint(i)+"\t")
  //getting size of array input from user
  print("Enter number of elements=>")
  var unSortedArray = Array.ofDim[Int](scala.io.StdIn.readInt())
  //inserting random elements in array
  for(i<-unSortedArray.indices) unSortedArray(i) = Random.nextInt(100)
  //before sorting
  printArray(unSortedArray)
  println("\n")
  //calling inSort method to sort
  this.inSort(unSortedArray)
  //after sorting
  printArray(unSortedArray)
}
