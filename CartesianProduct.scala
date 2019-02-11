
/*Program in Scala for finding Cartesian Product
          With the help of indices*/

object Main
{
    //Function to find the Cartesian Product
    def CartesianProduct(arr1 : Array[Int], arr2 : Array[Int])
    {
        for(i <- arr1.indices)
            for(j <- arr2.indices)
            //Displaying the output
                println("(" + arr1(i) +", "+ arr2(j) + ")")
    }
    
    //Driver Code
	def main(args: Array[String])
	{
	    //Initialization of arrays
	    var arr1 = Array(1, 2, 3)
	    var arr2 = Array(4, 5, 6)

	    //Function calling
	    CartesianProduct(arr1, arr2)
	}
}