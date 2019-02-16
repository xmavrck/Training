//following program will calculate combinations with combinations in scala

object combinationsWithRep extends App {

  //we flatten the list and then apply combinations to it (kind of divide and conquer
  def multi[A](as: List[A], k: Int): List[List[A]] =
    List.fill(k)(as).flatten.combinations(k).toList
  print("Enter number of choices=>")
  val newList = List.range(1, scala.io.StdIn.readInt()+1)
  print("Enter number of items to choose=>")
  val choose = scala.io.StdIn.readInt()
  val bonus = multi(newList, choose).size
  println("There are " + bonus + " ways to choose 3 items from 10 choices")

}