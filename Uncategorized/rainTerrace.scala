/*

@author Akash on 13/2/19 6:46 PM

*/

//This program will compute the maximum accumulated water in some specific bars setup
import scala.util.Random

object rainTerrace extends App{
  //this is the runner function that calculates maximum water to be stored
  def findMaxWater(barsArrayRec: Array[Int], arrayLength: Int): Int ={
    var maxWater, leftMostBar, rightMostBar, lo = 0 //initializing variables
    var hi = n-1
    //loop until all values of barsArrayRec array are parsed
    while(lo <= hi){
      if(barsArrayRec(lo) < barsArrayRec(hi)){
        //check if lo element of barsArrayRec is lesser than of hi
        //if lo element of barsArrayRec is greater than left most array element
        if(barsArrayRec(lo) > leftMostBar) leftMostBar = barsArrayRec(lo)
        else {
          //updating maxWater state
          maxWater += getSub(leftMostBar,barsArrayRec(lo))
          lo+=1
        }
      }else{
        //if hi element of barsArrayRec is greater than right most array element
        if(barsArrayRec(hi) > rightMostBar) rightMostBar = barsArrayRec(hi)
        else{
          //updating maxWater state
          maxWater += getSub(rightMostBar,barsArrayRec(hi))
          hi-=1
        }
      }
    }
    //returns maxWater
    maxWater
  }

  //this will returns subtraction of two numbers
  def getSub(valOne: Int, valTwo: Int)= valOne - valTwo

  //getting user input of number of bars/walls
  print("Enter number of bars:")
  val n = scala.io.StdIn.readInt()
  //declaring size of barsArray
  var barsArray = Array.ofDim[Int](n)
  //random bar size of maximum value 6 and printing it
  for(i<-0 until n){
    barsArray(i) = Random.nextInt(6)
    print(barsArray(i)+"\t")
  }
  //printing maximum accumulated water
  println("\nMaximum accumulated water:"+findMaxWater(barsArray, barsArray.length))

}