
/*Program in Scala for Maximum Subarray Problem*/

object Main {
    //function for finding maximum subarray
    def MaxSubArr(arr: Array[Int], size: Int): Int={
        var max, maxend, i: Int = 0
        for(i <- 0 until size)
        {
            maxend = maxend + arr(i)
            if(max < maxend)
                max = maxend
            if(maxend < 0)
                maxend = 0
        }
        return max
    }
    //driver code
	def main(args: Array[String]) {
		var arr = Array(-2, -3, 4, -1, -2, 1, 5, -3, 4, 2, -8)
		//calculating the size of array
		var n: Int = arr.length
		//displaying the output
		var maxsum: Int = MaxSubArr(arr, n)
		println("Maximum sum is : "+maxsum)
	}
}