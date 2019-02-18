package main

import "fmt"

var graph [50][50]int
var visited [20]int
var n int

func dfS(i int) {
	fmt.Printf("%d ", i)
	visited[i] = 1
	for j := 0; j < n; j++ {
		if visited[j] == 0 && graph[i][j] == 1 {
			dfS(j)
		}
	}
}
func main() {
	fmt.Printf("Enter the no of vertices: ")
	fmt.Scanf("%d", &n)
	fmt.Printf("Enter the adjecency matrix:\n ")
	for i := 0; i < n; i++ {
		fmt.Printf("enter the element in vertix: %d\n", i+1)
		for j := 0; j < n; j++ {
			fmt.Scanf("%d", &graph[i][j])
		}
	}
	for i := 0; i < n; i++ {
		visited[i] = 0
	}
	fmt.Printf("the path is: ")
	dfS(0)
}
