package main

import "fmt"

func ipSearch(array []int, key int) int {
	min := array[0]
	max := array[len(array)-1]
	low := 0
	high := len(array) - 1
	for {
		if key < min {
			return low
		}
		if key > max {
			return high + 1
		}
		// making a guess of the location
		var guess int
		if high == low {
			guess = high
		} else {
			size := high - low
			offset := int(float64(size-1) * (float64(key-min) / float64(max-min)))
			guess = low + offset
		}
		// maybe we found it?
		if array[guess] == key {
			// scan backwards for start of value range
			for guess > 0 && array[guess-1] == key {
				guess--
			}
			return guess
		}
		// if we guessed to high, guess lower or vice versa
		if array[guess] > key {
			high = guess - 1
			max = array[high]
		} else {
			low = guess + 1
			min = array[low]
		}
	}
}

func main() {

	var n, key int
	var array []int
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d", &n)
	array = make([]int, n)
	fmt.Printf("Enter the element in sorted form:\n")
	for i := 0; i < n; i++ {
		fmt.Scanf("%d ", &array[i])
	}
	fmt.Printf("\nEnter the element to be searched: ")
	fmt.Scanf("%d", &key)
	fmt.Printf("\nElement found at index: ")
	fmt.Println(ipSearch(array, key))

}
