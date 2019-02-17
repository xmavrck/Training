package main

import "fmt"

var inf = 999
var v int

func floydWarshell(array [][]int) {
	var dist [100][100]int

	for i := 0; i < v; i++ {
		for j := 0; j < v; j++ {
			dist[i][j] = array[i][j]
		}
	}

	for k := 0; k < v; k++ {
		for i := 0; i < v; i++ {
			for j := 0; j < v; j++ {
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

func main() {

	var array [][]int
	fmt.Printf("Enter the no. of vertices: ")
	fmt.Scanf("%d", &v)
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
