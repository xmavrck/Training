
/*Program for Interpolation Search in Scala*/

object Main 
{
    var arr = Array(10, 12, 13, 16, 18, 19, 20, 21)
    //Function for Interpolation Search
    def InterpolationSearch(key: Int): Int=
    {
        var low, pos: Int = 0
        //length of array
        var high: Int = (arr.length-1)
        //searching the element
        while (low <= high && key >= arr(low) && key <= arr(high))
        {
            pos = low + (((high-low) / (arr(high)-arr(low)))*(key - arr(low)))
            if (arr(pos) == key) 
                return pos; 
            if (arr(pos) < key)
                low = pos + 1
            else
                high = pos - 1
        }
        return -1
    }
    //driver code
	def main(args: Array[String])
	{
	    //initialization
	    var key: Int = 18;
	    //element location
        var index: Int = InterpolationSearch(key)
        //displayong the output
        if (index == -1) 
            println("Element not found ")
        else
            println("Element found at index : "+index)
	}
}