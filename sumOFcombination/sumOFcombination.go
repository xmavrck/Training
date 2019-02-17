package main

import "fmt"

var n int
var array [100]int

func combinRecursive(array [100]int, index int, num int, reduce int) {
	var prev int
	if reduce < 0 {
		return
	}
	if reduce == 0 {
		for i := 0; i < index; i++ {
			fmt.Printf("%d ", array[i])
		}
		fmt.Printf("\n")
	}
	if index == 0 {
		prev = 1
	} else {
		prev = array[index-1]
	}

	for k := prev; k <= num; k++ {
		array[index] = k
		combinRecursive(array, index+1, num, reduce-k)
	}
}
func findCombination(n int) {
	combinRecursive(array, 0, n, n)
}

func main() {
	var n int
	fmt.Printf("Enter a number:\n ")
	fmt.Scanf("%d", &n)
	fmt.Printf("All possible combinations are: \n")
	findCombination(n)

}
