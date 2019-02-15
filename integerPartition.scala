/*

@author akash

@readCase "print and println are used to customize the output screen"

*/

//this program will ceck in how many ways an integer can be divided
object integerPartition extends App {
  //getting matrix size inputs from user
  print("Enter number=>")
  val num = scala.io.StdIn.readInt()

  //defining matrix size
  var matrix = Array.ofDim[Int](num+1,num+1)

  //filling first row to 0
  for(i<-1 to num) matrix(0)(i) = 0

  //filling first column to 1
  for(i<-0 to num) matrix(i)(0) = 1

  //traversing and finding combinations of a number that it can be divided into
  for(x<-1 to num) for(y<-1 to num) {
    if(x > y) matrix(x)(y) = matrix(x-1)(y)
    else{
      val comboWithout = matrix(x-1)(y)
      val comboWith = matrix(x)(y-x)
      matrix(x)(y) = comboWithout + comboWith
    }
  }

  //printing ways
  println(num+" can be divided into "+matrix(num)(num)+" ways")
}
