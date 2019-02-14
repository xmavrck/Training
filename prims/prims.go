package main

import "fmt"

var a [][]int
var n int
var span [20][20]int

func prims() int {
	var mincost, mindistance, v, u, noe int
	var distance [20]int
	var visited [20]int
	var from [20]int
	var cost [20][20]int
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if a[i][j] == 0 {
				cost[i][j] = 9999
			} else {
				cost[i][j] = a[i][j]
				span[i][j] = 0
			}
		}
	}
	distance[0] = 0
	visited[0] = 1
	for i := 1; i < n; i++ {
		distance[i] = cost[0][i]
		from[i] = 0
		visited[i] = 0
	}
	mincost = 0
	noe = n - 1
	for noe > 0 {
		mindistance = 9999
		for i := 1; i < n; i++ {
			if visited[i] == 0 && distance[i] < mindistance {
				v = i
				mindistance = distance[i]
			}
		}
		u = from[v]
		span[u][v] = distance[v]
		span[v][u] = distance[v]
		noe--
		visited[v] = 1

		for i := 1; i < n; i++ {
			if visited[i] == 0 && cost[i][v] < distance[i] {
				distance[i] = cost[i][v]
				from[i] = v
			}
		}
		mincost += cost[u][v]
	}
	return mincost
}

func main() {
	fmt.Printf("enter the number of vertices: ")
	fmt.Scanf("%d", &n)
	a = make([][]int, n)
	for i := 0; i < n; i++ {
		fmt.Printf("enter the element in row: %d\n", i+1)
		a[i] = make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Scanf("%d", &a[i][j])
		}
	}
	total := prims()
	fmt.Printf("\nspanning tree matrix:\n")
	for i := 0; i < n; i++ {
		fmt.Printf("\n")
		for j := 0; j < n; j++ {
			fmt.Printf("%d ", span[i][j])
		}
	}
	fmt.Printf("\nthe total cost is: %d", total)
}
