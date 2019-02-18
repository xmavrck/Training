//following will rotate a squared matrix to 90 degrees

object squareMatrixRotation extends App{
  def rotateMatrix(n: Int, rotationMatrix: Array[Array[Int]]): Unit ={
    for(x<-0 until n/2){ //This will loop the squares of matrix from outside to inside
      for(y<-x until n-x-1){ //current squared elements
        var temp = rotationMatrix(x)(y) //storing current element to
        rotationMatrix(x)(y) = rotationMatrix(y)(n-1-x) //right to top
        rotationMatrix(y)(n-1-x) = rotationMatrix(n-1-x)(n-1-y) //bottom to right
        rotationMatrix(n-1-x)(n-1-y) = rotationMatrix(n-1-y)(x) //left to bottom
        rotationMatrix(n-1-y)(x) = temp //temp to left
      }
    }
  }

  //this method will print matrix
  def printMatrix(rotationMatrix: Array[Array[Int]], n: Int): Unit ={
    for(x<-0 until n){
      for(y<-0 until n){
        print(rotationMatrix(x)(y)+"\t")
      }
      println()
    }
  }

  //asking to select maximum matrix x,y length
  print("max:")
  val n = scala.io.StdIn.readInt()
  val random = scala.util.Random
  var rotationMatrix = Array.ofDim[Int](n,n) //setting matrix size
  //following will create 2d matrix of random integers
  for(i<-0 until n){
    for(j<-0 until n){
      rotationMatrix(i)(j) = random.nextInt(100)
    }
  }
  printMatrix(rotationMatrix, n)
  println("#########")
  //we can loop through following to rotate more than 90 degrees
  rotateMatrix(n, rotationMatrix) //rotate matrix to 90 degrees left
  printMatrix(rotationMatrix, n)
}