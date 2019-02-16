/*

@author akash

@readCase "print and println are used to customize the output screen"

*/

//following program will find all the subsets of a set
object powerSet extends App{
  //runner method
  //foldleft the list and then apply flatmap on folded elem to generate a new seq of list as subset
  def powerSet[A](xs: List[A]): List[List[A]] =
    xs.foldLeft(List(Nil: List[A]))((accum, elem) => accum.flatMap(l => Seq(l, elem :: l)))
  //getting user input of set size
  print("How many elements in set=>")
  //generating a set till user defined value
  var elemList = List.range(1, scala.io.StdIn.readInt()+1)
  //printing subsets
  print(powerSet(elemList))
}
