package main

import "fmt"

func main() {
	var n int
	i := 5
	c := 2
	var f int
	fmt.Printf("\nEnter the range of prime number required:\n")
	fmt.Scanf("%d", &n)
	arr := make([]int, n)
	arr[0] = 2
	arr[1] = 3
	for i <= n {
		f = 1
		for j := 0; j < c && arr[j]*arr[j] <= i; j++ {
			if i%arr[j] == 0 {
				f = 0
				break
			}
		}
		if f > 0 {
			arr[c] = i
			c++
		}
		i++
	}
		fmt.Printf("\nPrime number upto %d are:\n", n)
	for i := 0; i < c; i++ {
		fmt.Print(arr[i])
		fmt.Print(" ")
	}
	fmt.Printf("\nTotal Prime numbers are %d: \n", c)
	}
