package main

import (
	"fmt"
	"regexp"
)

func main() {
	var str0, str1 string
	fmt.Println("Input a String in small case: ")
	fmt.Scanf("%s" , &str0)
	fmt.Println("Note:\n'.' matches any single character\n'*' matches zero or more of the preceding element")
	fmt.Println("Input a pattern:  ")
	fmt.Scanf("%s ", &str1)
	matched, _ := regexp.MatchString(str1, str0)
	fmt.Println(matched)
}
