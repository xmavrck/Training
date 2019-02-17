
/*Program in Scala for Jump or Block Search*/

import scala.math.sqrt
import util.control.Breaks._
object Main {
    //function for finding the minimum value
    def min(a: Int, b: Int):Int={
        if(a<b) return a 
        else return b }
        //function for searching the element
    def JumpSearch(arr: Array[Int], size: Int, Key: Int): Int = {
        var left, right, i, flag = 0
        //converting value to integer
        var jump: Int = sqrt(size).toInt
        breakable{
            while(arr(left) <= Key && left < size)
            {
                right = min(size-1, left + jump)
                //key does not exist
                if(arr(left) <= Key && arr(right) >= Key){
                    break()
                }
                //reassigning the left
                left = left+jump
            }
        }
        if(left >= size || arr(left)>Key) return -1
        right = min(size - 1, right)
        for(i <- left until right){
            if(arr(i) == Key)  /*Key found*/  {
                flag = 1
            }
            else /*Key not found*/flag = 0
        }
        //displaying the output
        if(flag == 1) print("Element found")
        else print("Not Found")
        return -1
    }
    //driver code
	def main(args: Array[String]) {
		var arr = Array(1,2,3,4,5,6,7,8)
		var Key = 4
		//length of array
	    var size = arr.length
	    //calling the function
	    JumpSearch(arr, size, Key)
	}
}