package main

import "fmt"

var array []int

func inSert(array []int) {
	for i := 0; i < len(array); i++ {
		key := array[i]
		j := i - 1
		for j >= 0 && array[j] > key {
			array[j+1] = array[j]
			j--
		}
		array[j+1] = key
	}
}

func printArray(array []int) {
	for i := 0; i < len(array); i++ {
		fmt.Printf("%d \t", array[i])
	}
}

func main() {
	var n int
	fmt.Printf("Enter size of array:")
	fmt.Scanf("%d ", &n)
	array = make([]int, n)
	fmt.Printf("Enter the sorted element in the array:\n")
	for i := 0; i < n; i++ {
		fmt.Scanf("%d ", &array[i])
	}
	inSert(array)
	printArray(array)
}
