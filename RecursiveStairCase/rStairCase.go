package main

import "fmt"

func fib(x int) int {
	if x <= 1 {
		return x
	}
	return fib(x-1) + fib(x-2)

}
func count(x int) int {
	return fib(x + 1)

}
func main() {
	var n int
	fmt.Println("Enter no. of staircase:")
	fmt.Scanf("%d", &n)
	fmt.Println("No. of ways: ", count(n))
}
