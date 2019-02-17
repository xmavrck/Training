
/*Program in Scla for Combinations*/

object combinWithRep extends App {

  //Flatten the list and apply combinations to it
  def multi[A](as: List[A], k: Int): List[List[A]] =
  //List flatten
    List.fill(k)(as).flatten.combinations(k).toList
    //making a new list with incremented length
  val newList = List.range(1, 5+1)
  val choose = 7
  val bonus = multi(newList, choose).size
  //displaying the output
  println("There are " + bonus + " ways to choose 3 items from 10 choices")
}