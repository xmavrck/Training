
/*Program for Radix Sort in Scala*/

object Main {
    //Function for finding the largest element in an array
    def Largest(arr: Array[Int], n: Int): Int=
    {
        var large: Int = arr(0)
        var i: Int = 0
        //Comparing each element of an array
        for(i <- 1 until n)
        {
            if(large < arr(i))
                large = arr(i)
        }
        return large
    }
    
    //functionn for finding sorting the array
    def RadixSort(arr: Array[Int], n: Int)
    {
        var arr1 = Array.ofDim[Int](10,10)
        var arr2 = Array.ofDim[Int](10)
        var i, j, k, large, remainder, pass, count: Int = 0
        var divisor: Int = 1
        large = Largest(arr, n);
        while(large > 0)
        {
            count = count+1
            large = large / 10
        }
        for(pass <- 0 until count)
        {
            for(i <- 0 until 10)
            {
                arr2(i) = 0
            }
            for(i <- 0 until n)
            {
                remainder = (arr(i) / divisor) % 10
                arr1(remainder)(arr2(remainder)) = arr(i)
                arr2(remainder) = arr2(remainder) + 1
            }
            i = 0
            for(k <- 0 until 10)
            {
                for(j <- 0 until arr2(k))
                {
                    arr(i) = arr1(k)(j)
                    i = i+1
                }
            }
            divisor = divisor * 10
            /* For printing the multi digit sorted array
                for(i <- 0 until n)
                {
                    println(arr(i))
                }
            */
        }
    }
    //Driver Code
	def main(args: Array[String]) {
	    var i: Int = 0
	    var arr = Array(21, 32, 11, 58, 98, 45,34, 65)
	    var n: Int = arr.size
	    //function calling
	    RadixSort(arr, n)
	    //displaying the array in sorted form
	    println("Sorted elements are : ")
	    for(i <- 0 until n)
	    {
	        println(arr(i))
	    }
	}
}