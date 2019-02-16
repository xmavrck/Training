import scala.util.Random

/*

@author akash

@readCase "print and println are used to customize the output screen"

*/
//following program will sort array of elements using shell Sort method
object shellSort extends App {

  //this method will get array as input and perform shell sort on it
  def sortMethod(arrayElems: Array[Int]): Unit ={
    val n = arrayElems.length //array length
    var gap = n/2
    while(gap > 0){
      for(i<-gap until n){
        val temp = arrayElems(i)
        var j=i
        while(j>=gap && arrayElems(j-gap)>temp) {
          //swapping values
          arrayElems(j) = arrayElems(j-gap)
          j-=gap
        }
        //updaing values
        arrayElems(j) = temp
      }
      gap /= 2 //updating while loop
    }
  }
  def printArray(arrayElem: Array[Int]): Unit = for(i<-arrayElem.indices) print(arrayElem(i)+"\t")
  //user input to get size of array
  print("How many elements?")
  var arrayElems = Array.ofDim[Int](scala.io.StdIn.readInt())

  //generating random array elems
  for(i<-arrayElems.indices) arrayElems(i) = Random.nextInt(100)
  print("Before Sorting:")
  printArray(arrayElems)
  print("\nAfter Sorting:")
  this.sortMethod(arrayElems)
  printArray(arrayElems)

}
