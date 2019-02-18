//quicksort class
class QuickSort {
  //recursive sort method to sort array that receives array[low-high] as input
  def sort(arr: Array[Int], low: Int, high: Int): Unit = {
    if (low < high) {
      val pi = partitioning(arr, low, high) //finding pivot by partitioning
      sort(arr, low, pi - 1) //recursive left sub-array sorting
      sort(arr, pi + 1, high) //recursive right sub-array sorting
    }
  }
  def partitioning(arr: Array[Int], low: Int, high: Int): Int = {
    var pivot = arr(high) //last element is set to pivot
    var i: Int = low - 1
    for(j <- low until high){
      //only if current element is smaller than or equals to pivot element
      if(arr(j) <= pivot){
        i = i + 1
        //swapping arr(i) with arr(j)
        val temp=arr(i)
        arr(i)=arr(j)
        arr(j)=temp
      }
    }
    //swapping arr(i+1) with arr(high)
    val temp=arr(i+1)
    arr(i+1)=arr(high)
    arr(high)=temp
    i + 1
  }
}

object QS {
  //printing sorted array
  def printA(arr: Array[Int]): Unit ={
    for(a <- arr.indices) print(arr(a)+" ")
  }
  def main(args: Array[String]): Unit = {
    val arr = Array(10, 7, 8, 9, 1, 5)
    val qs = new QuickSort
    qs.sort(arr,0, arr.length-1)
    printA(arr)
  }
}
