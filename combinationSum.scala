import scala.util.control.Breaks
import scala.collection.mutable.ArrayBuffer

//following class will find all distinct combinational sum vectors
class combinationSum{
  var result: Vector[Vector[Int]] = Vector() // empty final vector
  //combination is current branch using DFS
  def DFS(combination: ArrayBuffer[Int], candidates: Array[Int], target: Int, startIndex: Int): Vector[Vector[Int]] ={
    //if target path of dfs make sum equal to the desired sum
    if(target == 0){
      result = result :+ ArrayBufferToVector(combination)
      result
    }else {
      var loop = new Breaks
      loop.breakable {
        //looping through candidates array from passed index position
        for (i <- startIndex until candidates.length) {
          if (candidates(i) > target) {
            loop.break()
          }
          combination += candidates(i) // add current candidate to combination
          DFS(combination, candidates, target - candidates(i), i) //recursive call to DFS
          combination.remove(combination.length - 1) //removed last stored element from current combination buffer
        }
      }
      result
    }
  }
  //this will convert arraybuffer into vector form
  def ArrayBufferToVector(combination: ArrayBuffer[Int]): Vector[Int] ={
    if(combination.nonEmpty) {
      var nVec: Vector[Int] = Vector()
      for(x<-combination.indices) nVec = nVec :+ combination(x)
      nVec
    }else Vector()
  }
}

object cs {
  def main(args: Array[String]): Unit = {
    var combination: ArrayBuffer[Int] = ArrayBuffer()
    var candidates: Array[Int] = Array(1,2,3,2,132,12,3,34) //Array(3,2,6,7)
    var target = 7
    //quicksort is used to sort candidate array
    val QuiSor = new QuickSort
    QuiSor.sort(candidates, 0, candidates.length-1)
    //remove duplicate elements from array
    candidates = candidates.distinct
    val csum = new combinationSum
    var result: Vector[Vector[Int]] = csum.DFS(combination, candidates, target, 0)
    println(s"$result") //printing result vector
  }
}
