/*

@author akash

@readCase "print and println are used to customize the output screen"

*/

//following program will calculate all alternatives of climbing stairs by 1 or 2 steps only
object recursiveStaircase extends App {
  def recStaircase(stairCase: Int): Int ={
    stairCase match {
      case 0 => 0
      case 1 => 1
      case 2 => 2
      case _ => recStaircase(stairCase-1) + recStaircase(stairCase-2)
    }
  }
  print("Enter number of stairs:")
  val stairs = scala.io.StdIn.readInt()
  print("Total number of ways, the person can reach the top=>"+recStaircase(stairs))
}
