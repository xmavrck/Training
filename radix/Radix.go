package main

import (
	"fmt"
)

var n int

func maximum(ary []int) int {
	max := 0

	for i := 0; i < n; i++ {
		if ary[i] > max {
			max = ary[i]
		}
	}
	return max
}

func radix(ary []int) []int {
	max := maximum(ary)
	significantDigit := 1
	semiSorted := make([]int, n, n)
	for max/significantDigit > 0 {
		bucket := [10]int{0}
		for i := 0; i < n; i++ {
			bucket[(ary[i]/significantDigit)%10]++
		}
		for i := 1; i < 10; i++ {
			bucket[i] += bucket[i-1]
		}
		for i := n - 1; i >= 0; i-- {
			bucket[(ary[i]/significantDigit)%10]--
			semiSorted[bucket[(ary[i]/significantDigit)%10]] = ary[i]
		}
		for i := 0; i < n; i++ {
			ary[i] = semiSorted[i]
		}

		significantDigit *= 10
	}

	return ary
}

func main() {
	fmt.Println("Enter the size of the ary")
	fmt.Scanf("%d", &n)
	fmt.Println("Enter the element in the ary")
	unsl := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scanf("%d", &unsl[i])
	}
	sl := radix(unsl)
	fmt.Printf("Sorted List: %d", sl)
	fmt.Println("")

}
