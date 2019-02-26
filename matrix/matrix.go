package main

import (
	"fmt"
)

var arr [][]int
var n int

func input() {

	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d ", &n)
	arr = make([][]int, n)
	for i := 0; i < n; i++ {
		fmt.Printf("enter the element in row: %d\n", i+1)
		arr[i] = make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Scanf("%d ", &arr[i][j])
		}
	}

}
func rotate(n int, arr [][]int) {
	var i, j int
	for i = 0; i < n/2; i++ {
		for j = 0; j < n-i-1; j++ {
			var temp = arr[i][j]
			arr[i][j] = arr[j][n-1-i]
			arr[j][n-1-i] = arr[n-1-i][n-1-j]
			arr[n-1-i][n-1-j] = arr[n-1-j][i]
			arr[n-1-j][i] = temp
		}
	}
}
func print() {
	for i := 0; i < n; i++ {
		fmt.Printf("\n")
		for j := 0; j < n; j++ {
			fmt.Printf("%d \t", arr[i][j])
		}
	}
}

func main() {
	input()
	fmt.Printf("\nInputted Matrix :")
	print()
	rotate(n, arr)
	fmt.Printf("\nMatrix after rotation:")
	print()
}
