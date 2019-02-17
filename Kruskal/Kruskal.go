package main

import "fmt"

var n int
var parent []int

func find(i int) int {
	for parent[i] != i {
		i = parent[i]
	}
	return i
}
func union1(i int, j int) {
	a := find(i)
	b := find(j)
	parent[a] = b
}
func kruskalMST(cost [][]int) {
	var mincost = 0
	for i := 0; i < n; i++ {
		parent[i] = i
	}
	var edge = 0
	for edge < n-1 {
		var min = 9999
		var a, b = -1, -1
		for i := 0; i < n; i++ {
			for j := 0; j < n; j++ {
				if find(i) != find(j) && cost[i][j] < min {
					min = cost[i][j]
					a = i
					b = j
				}
			}
		}
		union1(a, b)
		edge++
		fmt.Printf("Edge %d: (%d, %d) cost: %d \n", edge, a, b, min)
		mincost += min
	}
	fmt.Printf("\n Minimum cost: %d \n", mincost)
}
func main() {
	var cost [][]int
	fmt.Printf("Enter the no of vertices: ")
	fmt.Scanf("%d", &n)
	parent = make([]int, n)
	cost = make([][]int, n)
	fmt.Printf("Enter the adjecency matrix:\n ")
	for i := 0; i < n; i++ {
		cost[i] = make([]int, n)
		fmt.Printf("enter the element in vertix: %d\n", i+1)
		for j := 0; j < n; j++ {
			fmt.Scanf("%d", &cost[i][j])
		}
	}
	kruskalMST(cost)
}
