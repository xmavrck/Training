
/*Program for Binary Search Algorithm in Scala*/

import util.control.Breaks._
object Main {
    
	def main(args: Array[String])
	{
	    //Initialization of variables
	    //n is the size of array
	    var n: Int = 7
	    var first, last, mid, flag: Int = 0
	    var key: Int = 23
	    
	    //Aray initialization
	    var arr = Array(1, 6, 10, 13, 15, 19, 23)
	    
	    //Setting first and last to proper places
	    first = 0
	    last = n-1
	    
	    //Using break statement
	    breakable
	    {
    	    while(first <= last)
    	    {
                mid = (first + last) / 2
        	    if(key == arr(mid))
        	    {
        	        //If the element exists then set flag as 1
                    flag = 1
    	            break()
                }
        	    else
        	    {
        	        //If not found then reinitailize first and last
                    if(key > arr(mid))
                        first = mid + 1
    	            else
    	                last = mid - 1
        	     }
    	    }
	    }
	    
	    //Displaying the output
	    if(flag == 1){
	        println("Element found at location: "+(mid+1))
	    }
	    else{
	        println("Element not found")
	    }
	}
}