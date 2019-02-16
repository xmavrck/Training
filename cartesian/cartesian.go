package main

import "fmt"

func findCart(arr1 []int, arr2 []int, n int, n1 int) {
	for i := 0; i < n; i++ {
		fmt.Printf("\n")
		for j := 0; j < n1; j++ {
			fmt.Println("{", arr1[i], ",", arr2[j], "}")
		}
	}
}

func main() {
	var n1, n2 int
	var arr1, arr2 []int
	fmt.Printf("Enter the size of 1st array: ")
	fmt.Scanf("%d", &n1)
	arr1 = make([]int, n1)
	fmt.Printf("Enter the element in the array:\n")
	for i := 0; i < n1; i++ {
		fmt.Scanf("%d ", &arr1[i])
	}

	fmt.Printf("Enter the size of 1st array: ")
	fmt.Scanf("%d", &n2)
	arr2 = make([]int, n2)
	fmt.Printf("Enter the element in the array:\n")
	for i := 0; i < n1; i++ {
		fmt.Scanf("%d ", &arr2[i])
	}
	findCart(arr1, arr2, n1, n2)
}
