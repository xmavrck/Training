package main

import (
	"fmt"
)

func fastpower(n1 int, n2 int) int {
	res := 1
	for n2 > 0 {
		if n2%2 == 1 {
			res = (res * n1)
		}
		n1 = (n1 * n1)
		n2 = n2 / 2
	}

	return res
}
func main() {
	var n1, n2 int
	fmt.Println("Enter number: ")
	fmt.Scanf("%d", &n1)
	fmt.Println("Enter power: ")
	fmt.Scanf("%d", &n2)
	result := fastpower(n1, n2)
	fmt.Println(result)
}
