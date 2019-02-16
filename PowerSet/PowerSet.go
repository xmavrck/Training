package main

import "fmt"

func powerSet(str string, index int, curr string) {
	var n = len(str)

	// base case
	if index == n {
		fmt.Printf("{%s},", curr)
		return
	}
	powerSet(str, index+1, curr+string(str[index]))
	powerSet(str, index+1, curr)

}
func main() {
	var str string
	fmt.Printf("Enter a string:\n")
	fmt.Scanf("%s", &str)
	fmt.Printf("Sets of Inputted String are:\n")
	powerSet(str, 0, "")
	fmt.Printf("\n")
}
