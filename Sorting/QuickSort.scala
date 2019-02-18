
/*Program fo Quick Sort in Scala*/

object Main {
    
    //Function for making partition
    def Partition(arr: Array[Int], low: Int, high: Int): Int=
    {
        //Setting pivot element
        var pivot: Int = arr(high)
        var i = (low-1)
        var j: Int = 0
        var temp: Int = 0
        for(j <- low until high)
        {
            if (arr(j) <= pivot) 
            { 
                i = i+1
                //Swap
                temp = arr(i) 
                arr(i) = arr(j) 
                arr(j) = temp 
            } 
        }
        //Swapping the elements
        temp = arr(i+1) 
        arr(i+1) = arr(high)
        arr(high) = temp
        return i+1
    }
    
    //Function for sorting the given array
    def Sort(arr: Array[Int], low: Int, high:Int)
    {
        if(low < high)
        {
            //Setting the pivot
            var pi: Int = Partition(arr, low, high)
            Sort(arr, low, pi-1) 
            Sort(arr, pi+1, high)
        }
    }
    
    //Printing the aray in sorted form
    def Display(arr: Array[Int])
    {
        var n: Int = arr.size
        for(i <- 0 until n)
            println(arr(i))
    }
    
    //Driver Code
	def main(args: Array[String]) {
	    var arr = Array(10, 27, 8, 19, 20, 16)
	    var n: Int = arr.size
	    Sort(arr, 0, n-1)
	    println("Sortd array is: ")
	    Display(arr)
	}
}