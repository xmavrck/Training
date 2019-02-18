
/*Program in Scala for Rain Terrace*/

import scala.util.Random
object RainTerrace extends App
{
  //function for calculateing maximum water to be stored
  def findMaxWater(barsArrayRec: Array[Int], arrayLength: Int): Int =
  {
        //initializing variables
        var maxWater, leftMostBar, rightMostBar, low = 0
        var high = n-1
        while(low <= high)
        {
              if(barsArrayRec(low) < barsArrayRec(high))
              {
                if(barsArrayRec(low) > leftMostBar)
                    leftMostBar = barsArrayRec(low)
                else 
                {
                  //updating maxWater
                  maxWater = maxWater + getSub(leftMostBar,barsArrayRec(low))
                  low = low + 1
                }
              }
               else
               {
                    //if hi element of barsArrayRec is greater than right most array element
                    if(barsArrayRec(high) > rightMostBar) rightMostBar = barsArrayRec(high)
                    else
                    {
                      //updating maxWater state
                      maxWater += getSub(rightMostBar,barsArrayRec(high))
                      high = high-1
                    }
                }
        }
    //returns maxWater
    maxWater
  }

  //Function for subtracting two numbers
  def getSub(valOne: Int, valTwo: Int)= valOne - valTwo
  val n = 5
  //declaring size of barsArray
  var barsArray = Array.ofDim[Int](n)
  
  //random bar size of maximum value 6 
  for(i<-0 until n)
  {
    barsArray(i) = Random.nextInt(6)
    println(barsArray(i)+"\t")
  }
  //printing maximum water
  println("\nMaximum accumulated water will be: "+findMaxWater(barsArray, barsArray.length))

}