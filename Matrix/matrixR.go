package main

import (
	"fmt"
)

var array [][]int
var n int

func input() {

	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d", &n)
	array = make([][]int, n)
	for i := 0; i < n; i++ {
		fmt.Printf("enter the element in row: %d\n", i+1)
		array[i] = make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Scanf("%d", &array[i][j])
		}
	}

}
func rotate(n int, array [][]int) {
	var i, j int
	for i = 0; i < n/2; i++ {
		for j = 0; j < n-i-1; j++ {
			var temp = array[i][j]
			array[i][j] = array[j][n-1-i]         //RtT
			array[j][n-1-i] = array[n-1-i][n-1-j] //BtR
			array[n-1-i][n-1-j] = array[n-1-j][i] //LtB
			array[n-1-j][i] = temp
		}
	}
}
func display() {
	for i := 0; i < n; i++ {
		fmt.Printf("\n")
		for j := 0; j < n; j++ {
			fmt.Printf("%d\t", array[i][j])
		}
	}
}

func main() {
	input()
	fmt.Printf("\nInputted Matrix :")
	display()
	rotate(n, array)
	fmt.Printf("\nMatrix after rotation:")
	display()
}
