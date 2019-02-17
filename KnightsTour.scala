
/*Program in Scala for Knights Tour*/

object knightsTour extends App {
    //N*n board
  val N = 8
  // All 8 possible movements for a knight
  val row = Array(2, 1, -1, -2, -2, -1, 1, 2, 2)
  val col = Array(1, 2, 2, 1, -1, -2, -2, -1, 1)
  // VAlidation for a Knight
  def isValid(x: Int, y: Int): Boolean = {
    if (x < 0 || y < 0 || x >= N || y >= N) false
    else true
  }
  //for displaying the output
  def printl(visited: Array[Array[Int]]): Unit = {
    var i = 0
    for(i<-0 until N){
      for(j<-0 until N){
        print(visited(i)(j)+" ")
      }
      println()
    }
    println()
  }
  
  //Recursive call for knights tour
  def knightTour(visited: Array[Array[Int]], x: Int, y: Int, pos: Int): Unit = {
    visited(x)(y) = pos
    if (pos >= N * N) {
      printl(visited)
      visited(x)(y) = 0
      return
    }
    //check for all 8 possible movements
    var k = 0
    while (k < 8) {
      val nX = x + row(k)
      val nY = y + col(k)
      if(isValid(nX, nY) && visited(nX)(nY) == 0) knightTour(visited, nX, nY, pos + 1)
      k += 1
    }
    // backtrack from current and removing it
    visited(x)(y) = 0
  }
  var visited = Array.ofDim[Int](N, N)
  val pos = 1
  knightTour(visited, 0, 0, pos)
}