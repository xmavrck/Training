package main

import (
	"fmt"
)

func main() {
	var n1, n2, ch int
	var flag = 0
	fmt.Println("enter 1st number: ")
	fmt.Scanf("%d ", &n1)
	fmt.Println("enter 2nd number: ")
	fmt.Scanf("%d ", &n2)
	fmt.Println("enter any no. between 1 to 6 as to perform bit manipulation: ")
	fmt.Scanf("%d ", &ch)
	switch ch {
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
		fmt.Println("is power of two?")
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
	default:
		fmt.Println("Wrong input")
	}

}
