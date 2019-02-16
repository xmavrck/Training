
/*Implementation of Floyd Warshall Algorithm in Scala*/

object FloydWarshall extends App {
  //Initialization of variables
  var INF: Int = 99999//any infinite value
  var V: Int = 4

  //Function for all pair shortest path
  def FloydWarshall(graph: Array[Array[Int]]): Unit = {
    /*dist array stores the final result which stores
     the shortest path between every pair of vertices*/
    var dist = Array.ofDim[Int](V, V)

    //Initialized the resultant matrix to the original matrix
    for (i <- 0 until V) for (j <- 0 until V) dist(i)(j) = graph(i)(j)
    //Adding all the vertices one by one
    /*If the length between the vertices is
          shorter than update the distance matrix*/
    for(k <- 0 until V)
      for(i <- 0 until V)
        for(j <- 0 until V)
          if (dist(i)(k) + dist(k)(j) < dist(i)(j))
            dist(i)(j) = dist(i)(k) + dist(k)(j)

    //Displaying the resultant matrix
    for (i <- 0 until V) {
      for (j <- 0 until V) {
        if (dist(i)(j) == INF) print("INF\t")
        else print(dist(i)(j) + "\t")
      }
      println("\n")
    }
  }

  //Driver code

  //Giving the input matrix
  var graph = Array(Array(0, 5, INF, 10),
    Array(INF, 0, 3, INF),
    Array(INF, INF, 0, 1),
    Array(INF, INF, INF, 0)
  )
  //Function calling
  FloydWarshall(graph)

}