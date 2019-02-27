// C Program for Floyd Warshall Algorithm
package main

import "fmt"
/* Define Infinite as a large enough value. This value will be used
  for vertices not connected to each other */
var inf = 999
//Number of veritces in the Graph
var v int

func floydWarshell(array [][]int) {
	var dist [50][50]int

	for i := 0; i < v; i++ {

		for j := 0; j < v; j++ {
			dist[i][j] = array[i][j]
		}
	}

	for k := 0; k < v; k++ {
		// Pick all vertices as source one by one
		for i := 0; i < v; i++ {
			// Pick all vertices as destination for the
	    // above picked source
			for j := 0; j < v; j++ {
				// If vertex k is on the shortest path from
       // i to j, then update the value of dist[i][j]
				if dist[i][k]+dist[k][j] < dist[i][j] {
					dist[i][j] = dist[i][k] + dist[k][j]
				}
			}
		}
	}

	for i := 0; i < v; i++ {
		for j := 0; j < v; j++ {
			if dist[i][j] == inf {
				fmt.Printf("INF\t")
			} else {
				fmt.Printf("%d\t", dist[i][j])
			}
		}
		fmt.Printf("\n")
	}

}
// driver program to test above function
func main() {
	/* Let us enter  the values of following weighted graph */
	var array [][]int
	fmt.Printf("Enter the number of vertices: ")
	fmt.Scanf("%d ", &v)
	array = make([][]int, v)
	fmt.Printf("for infinity value, use '999':\n")
	fmt.Printf("Input the graph:\n")
	for i := range array {
		fmt.Printf("Input the vertice %d:\n", i+1)
		array[i] = make([]int, v)
		for j := range array[i] {
			fmt.Scanf("%d ", &array[i][j])
		}
	}
	fmt.Printf("\n\n Shortest Path \n")
	floydWarshell(array)
}
