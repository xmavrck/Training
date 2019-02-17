
/*Program in Scala for Power Set*/
object Power extends App{
   def Power[A](xs: List[A]): List[List[A]] =
    xs.foldLeft(List(Nil: List[A]))((accum, elem) => accum.flatMap(l => Seq(l, elem :: l)))
  //generating a set till user defined value
  var elemList = List.range(1, 5+1)
  //printing all the subsets
  print(Power(elemList))
}