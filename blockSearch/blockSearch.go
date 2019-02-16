package main

import (
	"fmt"
	"math"
)

func jumpSearch(arr []int, x int, n int) int {
	// Finding block size to be jumped
	var step = int(math.Sqrt(float64(n)))
	// Finding the block where element is
	// present (if it is present)
	var prev = 0
	for arr[int(math.Min(float64(step), float64(n))-1)] < x {
		prev = step
		step += int(math.Sqrt(float64(n)))
		if prev >= n {
			return -1
		}

	}

	// Doing a linear search for x in block
	// beginning with prev.
	for arr[prev] < x {
		prev++

		// If we reached next block or end of
		// array, element is not present.
		if prev == int(math.Min(float64(step), float64(n))) {
			return -1
		}

	}
	// If element is found
	if arr[prev] == x {
		return prev
	}
	return -1
}

func main() {
	var n, key int
	var array []int
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d", &n)
	array = make([]int, n)
	fmt.Printf("Enter the sorted element in the array:\n")
	for i := 0; i < n; i++ {
		fmt.Scanf("%d ", &array[i])
	}
	fmt.Printf("\nEnter the element to be searched: ")
	fmt.Scanf("%d", &key)
	fmt.Println("Fount at index", jumpSearch(array, key, n))
}
