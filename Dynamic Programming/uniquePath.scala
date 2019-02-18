/*

@author akash

@readCase "print and println are used to customize the output screen"

*/

//following program will calculate total number of unique paths from top-left to bottom-right
object uniquePath extends App {
  //getting row and column size inputs from user
  print("Enter row size=>")
  val rows = scala.io.StdIn.readInt()
  print("Enter column size=>")
  val columns = scala.io.StdIn.readInt()
  //defining board size
  var board = Array.ofDim[Int](rows,columns)
  //setting first row and column to 1
  for(i<-0 until rows) for(j<-0 until columns) if(i==0||j==0) board(i)(j) = 1
  //calculating next values and creating path (only right and bottom movement is allowed)
  for(i<-1 until rows) for(j<-1 until columns) {
      val uniquesFromTop = board(i - 1)(j)
      val uniquesFromLeft = board(i)(j - 1)
      board(i)(j) = uniquesFromTop + uniquesFromLeft
    }

  println("Total Number of Unique paths from start to end is:"+board(rows-1)(columns-1))
}
