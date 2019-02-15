package main

import "fmt"

var n, key int
var array []int

func input() {
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d", &n)
	array = make([]int, n)
	fmt.Printf("Enter the unsorted element in the array:\n")
	for i := 0; i < n; i++ {
		fmt.Scanf("%d ", &array[i])
	}
	fmt.Printf("\nEnter the element to be searched: ")
	fmt.Scanf("%d", &key)
}
func search(array []int, n int, key int) int {
	for i := 0; i < n; i++ {
		if array[i] == key {
			return i
		}
	}
	return -1
}

func main() {
	input()
	res := search(array, len(array)-1, key)
	fmt.Printf("Element found at position: %d\n", res+1)

}
