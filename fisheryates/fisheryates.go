package main

import (
	"fmt"
	"math/rand"
)

func fisheryate(array []int, n int) []int {
	for i := n - 1; i > 0; i-- {
		j := rand.Intn(i + 1)
		array[i], array[j] = array[j], array[i]
	}
	return array
}
func main() {
	var n int
	var array []int
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d ", &n)
	array = make([]int, n)
	fmt.Printf("Enter the element in the array:\n")
	for i := 0; i < n; i++ {
		fmt.Scanf("%d ", &array[i])
	}
	res := fisheryate(array, n)
	fmt.Println(res)
}
