
/*Program for Insertion Sort in Scala*/

object Main {
    
    //Function for sorting the array
    def InsertinSort(arr : Array[Int], n: Int)
    {
        var i, j, x: Int = 0
        //Inserting an element one by one
       for(i <- 1 until n)
       {
           x = arr(i)
           j = i-1
           while(j >= 0 && arr(j) > x)
           {
               arr(j+1) = arr(j)
               j = j-1
           }
           arr(j+1) = x
       }
    }
    //Function for displaying the sorted array
    def Display(arr : Array[Int], n: Int)
    {
        var i: Int = 0
        for(i <- 0 until n)
            println(arr(i))
    }
    
    //Driver Code
	def main(args: Array[String]) {
	    var arr = Array(10, 4, 12, 5, 2, 18)
	    //finding size of array
	    var n: Int = arr.size
	    //Function calling
	    InsertinSort(arr, n)
	    Display(arr, n)
	}
}