
/*Program in Scala for Kruskal Algorithm*/
object Main {
    var V = 5
    var parent = Array.ofDim(V)
    def Find(i: Int): Int={
        var j  = i
        while (parent(j) != j)
             j = parent(j)
        return j
    }
    //function for finding the union
    def Union(i: Int, j: Int){
        var k = i
        var a = Find(k)
        var b = Find(j)
        parent(a) = b
    }
    //implementig the algorithm
    def Kruskal(cost: Array[Array[Int]]) {
        var mincost, edge, i, j = 0
        var min = 9999
        var a, b = -1
        for(i <- 0 until V){
            var x = i
            parent(x) = i
            
        }
        while(edge < V-1){
            for(i <- 0 until V){
                for(j <- 0 until V){
                    if (Find(i) != Find(j) && cost(i)(j) < min){
                        min = cost(i)(j) 
                        a = i
                        b = j
                    }
                }
            }
            //displaying the output
            Union(a,b)
            println("Edge" + "=>" +edge +a +b +"Cost"+ "=>" +min)
        }
        print("Minimum Cost is: "+mincost)
    }//driver code
	def main(args: Array[String]) {
	    //setting an infinite value
	    var vl = 9999
	    //initializing the matrix
		var cost = Array(  Array(vl, 2, vl, 6, vl), 
                            Array(2, vl, 3, 8, 5), 
                            Array(vl, 3, vl, vl, 7), 
                            Array(6, 8, vl, vl, 9),
                            Array(vl, 5, 7, 9, vl)
                          );
        //calling the Kruskal function
        Kruskal(cost)
	}
}