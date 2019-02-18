object knightsTour extends App { // N x N chessboard
  val N = 8
  // Below arrays details all 8 possible movements for a knight.
  val row = Array(2, 1, -1, -2, -2, -1, 1, 2, 2)
  val col = Array(1, 2, 2, 1, -1, -2, -2, -1, 1)
  // Check if (x, y) is valid chess board coordinates
  // Note that a knight cannot go out of the chessboard
  def isValid(x: Int, y: Int): Boolean = {
    if (x < 0 || y < 0 || x >= N || y >= N) false
    else true
  }
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
  // Recursive function to perform the Knight's tour using backtracking
  def knightTour(visited: Array[Array[Int]], x: Int, y: Int, pos: Int): Unit = {
    // mark current square as visited
    visited(x)(y) = pos
    // if all squares are visited, print the solution
    if (pos >= N * N) {
      printl(visited)
      // backtrack before returning
      visited(x)(y) = 0
      return
    }
    // check for all 8 possible movements for a knight
    // and recurse for each valid movement
    var k = 0
    while (k < 8) {
      // Get the new position of Knight from current
      // position on chessboard
      val newX = x + row(k)
      val newY = y + col(k)
      // if new position is a valid and not visited yet
      if(isValid(newX, newY) && visited(newX)(newY) == 0) knightTour(visited, newX, newY, pos + 1)
      k += 1
    }
    // backtrack from current square and remove it from current path
    visited(x)(y) = 0
  }
  // visited[][] serves two purpose -
  // 1. It keep track of squares involved the Knight's tour.
  // 2. It stores the order in which the squares are visited
  var visited = Array.ofDim[Int](N, N)
  val pos = 1
  // start knight tour from corner square (0, 0)
  knightTour(visited, 0, 0, pos)
}