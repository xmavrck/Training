package main

import "fmt"

var n int
var arr [100]int
func main() {
	var n int
	fmt.Printf("Enter a number:\n ")
	fmt.Scanf("%d", &n)
	fmt.Printf("Possible combinations of number are: \n")
	findCombination(n)

}
func findCombination(n int) {  //function calling different function
	combinRecursive(arr, 0, n, n)
}
//Recursive function
func combinRecursive(array [100]int, index int, num int, reduce int) {
	var prev int
	if reduce < 0 {
		return
	}
	if reduce == 0 {
		for i := 0; i < index; i++ {
			fmt.Printf("%d ", arr[i])
		}
		fmt.Printf("\n")
	}
	if index == 0 {
		prev = 1
	} else {
		prev = arr[index-1]
	}

	for k := prev; k <= num; k++ {
		arr[index] = k
		combinRecursive(arr, index+1, num, reduce-k)
	}
}
