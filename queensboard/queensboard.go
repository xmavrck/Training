package main

import (
	"fmt"
)

var count = 0
var board [20]int

func print(n int) {
	var i int
	var j int
	count = count + 1
	fmt.Printf("\nsolution: %d\n", count)

	for i = 1; i <= n; i++ {
		fmt.Printf("\n\t")
		for j = 1; j <= n; j++ {
			if board[i] == j {
				fmt.Printf("Q\t")
			} else {
				fmt.Printf("*\t")
			}
		}
	}
	fmt.Printf("\n\n")
}

func place(row int, column int) int {

	var i int
	for i = 1; i <= (row - 1); i++ {
		if board[i] == column {
			return 0
		} else if (board[i]-column) == (i-row) || (board[i]-column) == -(i-row) {
			return 0
		}
	}
	return 1
}

func queen(row int, n int) {
	var column int
	for column = 1; column <= n; column++ {
		if place(row, column) > 0 {
			board[row] = column
			if row == n {
				print(n)
			} else {
				queen(row+1, n)
			}
		}
	}
}
func main() {
	var n int
	fmt.Println("Enter The Number of Queens: ")
	fmt.Scanf("%d", &n)
	queen(1, n)
	fmt.Println("\ntotal solutions: ", count)
}
