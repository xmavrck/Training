
/*Program in Scala for Matrix Rotation*/

object squareMatrixRotation extends App
{
    //Function for rotating the matrix
  def RotateMatrix(n: Int, rotMat: Array[Array[Int]]): Unit =
  {
    for(x<-0 until n/2)
    {
      for(y<-x until n-x-1)
      {
        //storing current element to temp
        var temp = rotMat(x)(y)
        //rotating right to top
        rotMat(x)(y) = rotMat(y)(n-1-x)
        //rotating bottom to right
        rotMat(y)(n-1-x) = rotMat(n-1-x)(n-1-y)
        //rotating left to bottom
        rotMat(n-1-x)(n-1-y) = rotMat(n-1-y)(x)
        //rotating temp to left
        rotMat(n-1-y)(x) = temp
      }
    }
  }

  //For displaying the matrix
  def printMatrix(rotMat: Array[Array[Int]], n: Int): Unit =
  {
    for(x<-0 until n){
      for(y<-0 until n){
        print(rotMat(x)(y)+"\t")
      }
      println()
    }
  }
  
  val n = 4
  //Generating random elements
  val random = scala.util.Random
  var rotMat = Array.ofDim[Int](n,n)
  
  //Create a 2d matrix with random integers
  for(i<-0 until n){
    for(j<-0 until n){
      rotMat(i)(j) = random.nextInt(100)
    }
  }
  //displaying the matrix
  printMatrix(rotMat, n)
  println("*****************")
  //Calling the function
  RotateMatrix(n, rotMat)
  printMatrix(rotMat, n)
}