
/*Program in Scala for Recursive Staircase*/

object RecursiveStaircase extends App {
    //Function for starcase
  def recStaircase(stairCase: Int): Int =
  {
      //multiple match cases for different conditions
        stairCase match
        {
            case 0 => 0
            case 1 => 1
            case 2 => 2
            //default case
            case _ => recStaircase(stairCase-1) + recStaircase(stairCase-2)
        }
  }
  val stairs = 8
  //displaying the output
  println("Total number of ways are : "+recStaircase(stairs))
}