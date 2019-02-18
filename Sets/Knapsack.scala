// following class will calculate maximum value
class Knapsack {
  def operation(values: Array[Int], weights: Array[Int], itemsCount: Int, maxWeight: Int): Int = {
    var Knap = Array.ofDim[Int](itemsCount+1,maxWeight+1) // declaring multidimensional array
    for(w<-0 to maxWeight) Knap(0)(w) = 0 // setting first row of weights to zero
    for(i<-1 to itemsCount){
      Knap(i)(0) = 0 // setting first column of item to zero
      for(w<-1 to maxWeight){
        if(weights(i-1) <= w) Knap(i)(w) = chooseMax(values(i-1) + Knap(i-1)(w-weights(i-1)),  Knap(i-1)(w)) // finding max
        else Knap(i)(w) = Knap(i-1)(w)
      }
    }
    Knap(itemsCount)(maxWeight) //returning max value
  }
  //this function will return max of two items
  def chooseMax(one: Int, two: Int): Int ={
    if (one > two) one else two
  }
}

object ks{
  def main(args: Array[String]): Unit = {
    var x = scala.io.StdIn //standard input
    print("How many numbers: ")
    var n = x.readInt()
    var random = scala.util.Random //random number generator utility
    var values = new Array[Int](n) //setting value array length to n
    var weights = new Array[Int](n) //setting weights array length to n
    //generating random integers for value and weight array
    for(i<-0 until n){
      values(i) = random.nextInt(100)
      weights(i) = random.nextInt(100)
    }
    print("Values:")
    for(i<-values.indices) print(values(i)+" ")
    println()
    print("Weights:")
    for(i<-weights.indices) print(weights(i)+" ")
    println()
    print("Max Weight:")
    val maxWeight = x.readInt()
    val obj = new Knapsack
    println("Max Profit value: "+obj.operation(values, weights, values.length, maxWeight))
  }
}
