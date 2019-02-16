package main

import "fmt"

func unique(row int, col int) int {
	if row == 1 || col == 1 {
		return 1
	} else {
		return unique(row-1, col) + unique(row, col-1)
	}
}
func main() {
	var row, col int
	fmt.Printf("Enter row & column:\n")
	fmt.Scanf("%d\n%d", &row, &col)
	res := unique(row, col)
	fmt.Println("No. of path: ", res)
}
