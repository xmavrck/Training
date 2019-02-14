package main

import "fmt"

var n, key int
var array []int

func input() {
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d", &n)
	array = make([]int, n)
	fmt.Printf("Enter the sorted element in the array:\n")
	for i := 0; i < n; i++ {
		fmt.Scanf("%d ", &array[i])
	}
	fmt.Printf("\nEnter the element to be searched: ")
	fmt.Scanf("%d", &key)
}
func search(array []int, key int, left int, right int) int {
	if left > right {
		return -1
	}
	mid := left + (right-left)/2
	if array[mid] == key {
		return mid
	} else if array[mid] > key {
		return search(array, key, left, mid-1)
	} else {
		return search(array, key, mid+1, right)
	}
}

func main() {
	input()
	res := search(array, key, 0, len(array)-1)
	fmt.Printf("Element found at position: %d\n", res+1)

}
