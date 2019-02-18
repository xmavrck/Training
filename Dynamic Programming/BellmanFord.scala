
/* Program for Bellman Ford Algorithm in Scala*/

object BellmanFord extends App {
  //Function for Bellman Ford Algorithm
  def BellmanFord(graph: Array[Array[Int]], V: Int, E: Int, edge: Array[Array[Int]]): Int = {
    //Declaring the variables
    var i, u, v, k: Int = 0
    var flag, S: Int = 1
    var parent = Array(2, 3, 4, 6, 8)
    var dist = Array(1, 9, 5, 7, 10)

    for (i <- 0 until V) {
      dist(i) = 1000
      parent(i) = -1
    }

    dist(S - 1) = 0
    for (i <- 0 until V - 1) {
      for (k <- 0 until E) {
        u = edge(k)(0)
        v = edge(k)(1)
        if (dist(u) + graph(u)(v) < dist(v)) {
          dist(v) = dist(u) + graph(u)(v)
          parent(v) = u
        }
      }
    }

    for (k <- 0 until E) {
      u = edge(k)(0)
      v = edge(k)(1)
      if (dist(u) + graph(u)(v) < dist(v)) {
        flag = 0
      }
    }
    //displeying the output
    if (flag == 1) {
      for (i <- 0 until V) {
        println("Vertex=>" + (i + 1) + "\tCost=>" + dist(i) + "\tParent=>" + (parent(i)+1))
      }
    }
    //returning the integer value
    flag
  }

  //Driver Code

  var i, j, k: Int = 0
  var edge = Array.ofDim[Int](20, 2)
  //Initializing the array elements
  var graph = Array(Array(0, 6, 0, 7, 0),
    Array(0, 0, 5, 8, -4),
    Array(0, -2, 0, 0, 0),
    Array(0, 0, -3, 0, 9),
    Array(2, 0, 7, 0, 0)
  )
  var V: Int = 5
  for (i <- 0 until V) {
    for (j <- 0 until V) {
      if (graph(i)(j) != 0) {
        edge(k)(0) = i
        edge(k + 1)(1) = j
      }
    }
  }
  //Function calling
  if (BellmanFord(graph, V, k, edge) == 1)
    println("No negative weight cycle")
  else
    println("Negative cycle exists")

}