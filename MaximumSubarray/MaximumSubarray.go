package main

import "fmt"

func subArray(a []int, size int) int {
	var max, min = -99999, 0

	for i := 0; i < size; i++ {
		min = min + a[i]
		if max < min {
			max = min
		}
		if min < 0 {
			min = 0
		}

	}
	return max
}

func main() {
	var n int
	var array []int
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d", &n)
	array = make([]int, n)
	fmt.Printf("Enter the sorted element in the array:\n")
	for i := 0; i < n; i++ {
		fmt.Scanf("%d ", &array[i])
	}
	fmt.Println("Maximum contiguous sum is ", subArray(array, n))
}
