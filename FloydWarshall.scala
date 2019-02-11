
/*Implementation of Floyd Warshall Algorithm in Scala*/

object Main {
    //Initialization of variables
    var INF: Int = 99999
    var V: Int = 4
    
    //Function for all pair shortest path
    def FloydWarshall(graph: Array[Array[Int]]): Unit =
    {
        /*dist array stores the final result which stores
         the shortest path between every pair of vertices*/
        var dist = Array.ofDim[Int](V,V)
        //Initialization of local variables
        var i: Int = 0
        var j: Int = 0
        var k: Int = 0
        
        //Initialized the resultant matrix to the original matrix
        for(i <- 0 until V)
        {
            for(j <- 0 until V)
            {
                dist(i)(j) = graph(i)(j)
            }
        }
        //Adding all the vertices one by one
        for(k <- 0 until V)
        {
            for(i <- 0 until V)
            {
                for(j <- 0 until V)
                {
                    /*If the length between the vertices is
                    shorter than update the distance matrix*/
                    if(dist(i)(k) + dist(k)(j) < dist(i)(j))
                    {
                        dist(i)(j) = dist(i)(k) + dist(k)(j)
                    }
                }
            }
        }
        
        //Displaying the resultant matrix 
        for(i <- 0 until V)
        {
            for(j <- 0 until V)
            {
                if(dist(i)(j) == INF)
                {
                    println("INF ")
                }
                else
                {
                    println(dist(i)(j)+ "  ")
                }
            }
        }
    }
    
    //Driver code
	def main(args: Array[String]): Unit =
	{
	    //Giving the input matrix
		var graph = Array( Array(0,   5,  INF, 10), 
                            Array(INF, 0,   3, INF), 
                            Array(INF, INF, 0,   1), 
                            Array(INF, INF, INF, 0) 
                          );
        //Function calling
        FloydWarshall(graph)
	}
}