
/*Program for Binary Search Algorithm in Scala*/

import scala.util.Random
import util.control.Breaks._
object BinarySearch extends App{
	//getting size of array input from user
	print("Enter number of elements=>")
	var elemArray = Array.ofDim[Int](scala.io.StdIn.readInt())
	//inserting random elements in array
	for(i<-elemArray.indices) elemArray(i) = Random.nextInt(100)

	insertionSort.inSort(elemArray)
	insertionSort.printArray(elemArray)

	print("\nEnter Element To search=>")
	val key = scala.io.StdIn.readInt()
	var first, last, mid, flag: Int = 0
	last = elemArray.length-1
	//Using break statement
	breakable {
		while(first <= last) {
			mid = (first + last) / 2
			if(key == elemArray(mid)) {
				//If the element exists then set flag as 1
				flag = 1
				break()
			} else {
				//If not found then reinitailize first and last
				if(key > elemArray(mid)) first = mid + 1
				else last = mid - 1
			}
		}
	}
	//Displaying the output
	if(flag == 1) println("Element found at location: "+mid)
	else println("Element not found")
}