package main

import "fmt"

func main() {
	var n int
	i := 5
	c := 2
	var f int
	fmt.Printf("---------------------------INPUT--------------------------------------")
	fmt.Printf("\nEnter the range of prime number required:\n")
	fmt.Scanf("%d", &n)
	fmt.Printf("---------------------------xxx--------------------------------------\n")
	array := make([]int, n)
	array[0] = 2
	array[1] = 3
	for i <= n {
		f = 1
		for j := 0; j < c && array[j]*array[j] <= i; j++ {
			if i%array[j] == 0 {
				f = 0
				break
			}
		}
		if f > 0 {
			array[c] = i
			c++
		}
		i++
	}
	fmt.Printf("---------------------------OUTPUT--------------------------------------")
	fmt.Printf("\nPrime number upto %d are:\n", n)
	for i := 0; i < c; i++ {
		fmt.Print(array[i])
		fmt.Print(" ")
	}
	fmt.Printf("\nTotal Prime numbers are %d: \n", c)
	fmt.Printf("---------------------------xxx--------------------------------------")

}
