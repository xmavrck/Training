package main

import "fmt"

func uniquepath(r int, c int) int {
	if r == 1 || c == 1 {
		return 1
	} else {
		return uniquepath(r-1, c) + uniquepath(r, c-1)
	}
}
func main() {
	var row, col int
	fmt.Printf("Enter row & column:\n")
	fmt.Scanf("%d\n%d", &row, &col)
	result := uniquepath(row, col)
	fmt.Println("Number of paths possible: ", res)
}
