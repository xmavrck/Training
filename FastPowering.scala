
/*Progarm for fast powering in Scala*/

object FastPowering extends App {
  //Function for calculating fast powering
  def FastPower(x: Int, y: Int): Int = {
    //for 0 power return 1
    if (y == 0) 1
    else if (y % 2 == 0) FastPower(x, y / 2) * FastPower(x, y / 2)
    else x * FastPower(x, y / 2) * FastPower(x, y / 2)
  }

  //driver code

  print("Enter value=>")
  val x = scala.io.StdIn.readInt()
  print("Enter power=>")
  val y = scala.io.StdIn.readInt()
  //displaying and calling the function
  println(FastPower(x, y))

}