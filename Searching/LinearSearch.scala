
/*Program for Linear Search in scala*/

import util.control.Breaks._
object Main {
	def main(args: Array[String]) {
	    //Initialization of arara
		var arr = Array(1, 2, 4, 7, 3, 10)
		var key: Int = 4
		var n: Int = arr.size
		var flag: Int = 1
		var i: Int = 0
		
		breakable
		{
		    //Checking each element of an array
		    for(i <- 0 until n)
		    {
    		    if(arr(i) == key)
    		    {
    		        //Element found
    		        flag = 1
    		        break()
    		    }
    		    else
    		        //Element not found
    		        flag = 0
		    }
		}
		
		//diaplaying the output
		if(flag == 1)
		    println("Emenet is present in the array")
		else
		    println("Element is not present in tha array")
	}
}