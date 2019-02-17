package main

import (
	"fmt"
	"math"
	"strings"
)

func lcsss(X string, Y string, m int, n int) int {
	if m == 0 || n == 0 {
		return 0
	}
	if X[m-1] == Y[n-1] {
		return 1 + lcsss(X, Y, m-1, n-1)
	}
	return int(math.Max(float64(lcsss(X, Y, m, n-1)), float64(lcsss(X, Y, m-1, n))))

}

func main() {
	var str1, str2 string
	fmt.Println("Input first String: ")
	fmt.Scanf("%s", &str1)
	fmt.Println("\nInput second String:  ")
	fmt.Scanf("%s", &str2)
	m := len(strings.Split(str1, ""))
	n := len(strings.Split(str2, ""))
	res := lcsss(str1, str2, m, n)
	fmt.Println("\nLength of LCS is", res)
}
