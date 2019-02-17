
/*Program in Scala for BFS*/

	class Graph[T] {
	  type Vertex = T
	  type GraphMap = Map[Vertex,List[Vertex]]
	  var g:GraphMap = Map()
	
	  def BFS(start: Vertex): List[List[Vertex]] = {
	
	    def BFS0(elems: List[Vertex],visited: List[List[Vertex]]): List[List[Vertex]] = {
	      val newNeighbors = elems.flatMap(g(_)).filterNot(visited.flatten.contains).distinct
	      if (newNeighbors.isEmpty)
	        visited
	      else
	        BFS0(newNeighbors, newNeighbors :: visited)
	    }
	
	    BFS0(List(start),List(List(start))).reverse
	  }
	}
	//runner object
	object graphBFS extends App {
	  var sGraph = new Graph[String]
	  //mapping graph
	  sGraph.g = Map("Dog" -> List ("Cat","Rabbit","Horse"), "Cat" -> List("Dog","Cow"), "Rabbit" -> List("Dog","Cow"), "Horse" -> List("Dog","Cow"), "Cow" -> List ("Cat","Rabbit","Horse"))
	  //parsing graph using BFS
	  println(sGraph.BFS("Dog"))
	}