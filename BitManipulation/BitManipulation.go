package main

import (
	"fmt"
)

func main() {
	var n1, n2 int
	var c = 0
	var flag = 0
	fmt.Println("enter 1st number: ")
	fmt.Scanf("%d", &n1)
	fmt.Println("enter 1st number: ")
	fmt.Scanf("%d", &n2)
	x := 4
	switch x {
	case 1:
		fmt.Println("Get bit")
		fmt.Println("Result is: ", n1&n2)
	case 2:
		fmt.Println("Set bit")
		fmt.Println("Result is: ", n1|n2)
	case 3:
		fmt.Println("Clear bit")
		fmt.Println("Result is: ", n1^n2)
	case 4:
		fmt.Println("is Even?")
		if n1%2 == 0 {
			fmt.Println("Yes ", n1, " is even")
		}
		if n2%2 == 0 {
			fmt.Println("Yes ", n2, " is even")
		}
	case 5:
		fmt.Println("is positive?")
		if n1 < 0 {
			fmt.Println("Yes ", n1, " is positive")
		}
	case 6:
		fmt.Println("Count set bit")
		for n1 != 0 {
			if n1&1 == 1 {
				c++
			}
			n1 = n1 >> 1
		}
	case 7:
		fmt.Println("is power of two")
		temp := n1
		for temp != 1 {
			if temp%2 != 0 {
				flag = 1
			}
			temp = temp / 2
		}
		if flag == 0 {
			fmt.Println(n1, " is in power of 2")
		} else {
			fmt.Println(n1, " is not in power of 2")
		}
	}

}
