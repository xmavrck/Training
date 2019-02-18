import scala.util.Random

/*

@author akash

*/

//folowing program will calculate cartesian product
object cartesianProduct extends App{

  //getting array size from user for two arrays
  print("Enter size of Array One:")
  var arrayOne = Array.ofDim[Int](scala.io.StdIn.readInt())
  print("Enter size of Array Two:")
  var arrayTwo = Array.ofDim[Int](scala.io.StdIn.readInt())

  //generating random values for both arrays
  for(i<-arrayOne.indices) arrayOne(i) = Random.nextInt(9)
  for(i<-arrayTwo.indices) arrayTwo(i) = Random.nextInt(9)

  //printing both arrays before cartesian product
  for(i<-arrayOne.indices) print(arrayOne(i)+"\t")
  println("\n")
  for(i<-arrayTwo.indices) print(arrayTwo(i)+"\t")

  //creating cartesian product
  val cartesianProd = arrayOne.flatMap(x=>arrayTwo.map((x,_)))
  println("\n")
  //printing all products
  cartesianProd foreach print

}
