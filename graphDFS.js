class Graph { 
    // defining vertex array and 
    // adjacent list 
    constructor(noOfVertices) 
    { 
        this.noOfVertices = noOfVertices; 
        this.AdjList = new Map(); 
    } 
  
  addVertex(v) 
    { 
        // initialize the adjacent list with a 
        // null array 
        this.AdjList.set(v, []); 
    } 
  addEdge(v, w) 
    { 
        // get the list for vertex v and put the 
        // vertex w denoting edge betweeen v and w 
        this.AdjList.get(v).push(w); 

        // Since graph is undirected, 
        // add an edge from w to v also 
        this.AdjList.get(w).push(v); 
    } 
  printGraph() 
      { 
          // get all the vertices 
          var get_keys = this.AdjList.keys(); 

          // iterate over the vertices 
          for (var i of get_keys)  
      { 
              // great the corresponding adjacency list 
              // for the vertex 
              var get_values = this.AdjList.get(i); 
              var conc = ""; 

              // iterate over the adjacency list 
              // concatenate the values into a string 
              for (var j of get_values) 
                  conc += j + " "; 

              // print the vertex and its adjacency list 
              console.log(i + " -> " + conc); 
          } 
      } 
 
dfs(startingNode) 
    { 

        var visited = []; 
        for (var i = 0; i < this.noOfVertices; i++) 
            visited[i] = false; 

        this.DFSUtil(startingNode, visited); 
    } 

    // Recursive function which process and explore 
    // all the adjacent vertex of the vertex with which it is called 
    DFSUtil(vert, visited) 
    { 
        visited[vert] = true; 
        console.log(vert); 

        var get_neighbours = this.AdjList.get(vert); 

        for (var i in get_neighbours) { 
            var get_elem = get_neighbours[i]; 
            if (!visited[get_elem]) 
                this.DFSUtil(get_elem, visited); 
        } 
    }  
}

//TEST
var g = new Graph(6); 
var vertices = [ 'A', 'B', 'C', 'D', 'E', 'F' ]; 
  
// adding vertices 
for (var i = 0; i < vertices.length; i++) { 
    g.addVertex(vertices[i]); 
} 
  
// adding edges 
g.addEdge('A', 'B'); 
g.addEdge('A', 'D'); 
g.addEdge('A', 'E'); 
g.addEdge('B', 'C'); 
g.addEdge('D', 'E'); 
g.addEdge('E', 'F'); 
g.addEdge('E', 'C'); 
g.addEdge('C', 'F'); 
  
console.log("DFS"); 
g.dfs('A'); 
