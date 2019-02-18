package main

import "fmt"

func printArray(x [50]int, n int) {
	for i := 0; i < n; i++ {
		fmt.Printf("{%d},", x[i])
	}
	fmt.Printf("\n")
}

func unique(n int) {
	var p [50]int
	var k = 0
	p[k] = n
	for {
		printArray(p, k+1)
		var remVal = 0
		for k >= 0 && p[k] == 1 {
			remVal += p[k]
			k--
		}
		if k < 0 {
			return
		}
		p[k]--
		remVal++
		for remVal > p[k] {
			p[k+1] = p[k]
			remVal = remVal - p[k]
			k++
		}
		p[k+1] = remVal
		k++
	}
}
func main() {
	var n int
	fmt.Printf("Enter a number:\n")
	fmt.Scanf("%d", &n)
	fmt.Printf("All unique partitions of %d are:\n", n)
unique(n)
}
