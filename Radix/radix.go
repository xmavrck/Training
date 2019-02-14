package main

import (
	"fmt"
)

var n int

func findLargestNum(array []int) int {
	largestNum := 0

	for i := 0; i < n; i++ {
		if array[i] > largestNum {
			largestNum = array[i]
		}
	}
	return largestNum
}

func radixSort(array []int) []int {

	fmt.Println("Running Radix Sort on Unsorted List")
	largestNum := findLargestNum(array)
	significantDigit := 1
	semiSorted := make([]int, n, n)
	for largestNum/significantDigit > 0 {
		bucket := [10]int{0}
		for i := 0; i < n; i++ {
			bucket[(array[i]/significantDigit)%10]++
		}
		for i := 1; i < 10; i++ {
			bucket[i] += bucket[i-1]
		}
		for i := n - 1; i >= 0; i-- {
			bucket[(array[i]/significantDigit)%10]--
			semiSorted[bucket[(array[i]/significantDigit)%10]] = array[i]
		}
		for i := 0; i < n; i++ {
			array[i] = semiSorted[i]
		}

		significantDigit *= 10
	}

	return array
}

func main() {
	fmt.Println("Enter the size of the array")
	fmt.Scanf("%d", &n)
	unsortedList := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scanf("%d", &unsortedList[i])
	}
	fmt.Println("Unsorted List: ", unsortedList)

	sortedList := radixSort(unsortedList)

	fmt.Println("Sorted List:", sortedList)
}
