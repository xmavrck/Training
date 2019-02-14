package main

import (
	"fmt"
)

func main() {
	var n, c int
	a := 0
	b := 1
	fmt.Println("Enter range: ")
	fmt.Scanf("%d", &n)
	fmt.Printf("Fibonacci series upto %d terms are: \n", n)
	for n > 0 {
		fmt.Printf("%d ", a)
		c = a + b
		a = b
		b = c
		n--
	}
	fmt.Printf("\n")
}
