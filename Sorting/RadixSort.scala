import scala.util.Random

/*

@author akash
Program for Radix Sort in Scala

*/

object RadixSort extends App {

    def getMax(ints: Array[Int]): Int ={
        var mx = 0
        for(x<-1 until ints.length) if(ints(x) > mx) mx = ints(x)
        mx
    }

    def countSort(intArray: Array[Int], i: Int): Unit ={
        val output = Array.ofDim[Int](intArray.length)
        var count = Array.ofDim[Int](10)
        for(x<-count.indices) count(x) = 0
        for(newx<-intArray.indices) count((intArray(newx)/i)%10) += 1
        for(anotherVar<-1 until 10) count(anotherVar) += count(anotherVar-1)
        var z = intArray.length-1
        while(z>=0){
            output(count((intArray(z)/i)%10)-1) = intArray(z)
            count((intArray(z)/i)%10) -= 1
            z-=1
        }
        for(y<-intArray.indices) intArray(y) = output(y)
    }

    def radixSort(inputArray: Array[Int]): Unit ={
        var m = getMax(inputArray)
        var x = 1
        while(m/x > 0){
            countSort(inputArray, x)
            x *= 10
        }
    }

    def printArray(arrayIn: Array[Int]): Unit = for(x<-arrayIn.indices) print(arrayIn(x) +"\t")

    print("How many Elements=>")
    var arrayUnsorted = Array.ofDim[Int](scala.io.StdIn.readInt())
    for(i<-arrayUnsorted.indices) arrayUnsorted(i) = Random.nextInt(500)
    print("Input array:")
    printArray(arrayUnsorted)
    this.radixSort(arrayUnsorted)
    print("\nOutput array:")
    printArray(arrayUnsorted)
}