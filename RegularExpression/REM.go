package main

import (
	"fmt"
	"regexp"
)

func main() {
	var str1, str2 string
	fmt.Println("Input a String in small case: ")
	fmt.Scanf("%s", &str1)
	fmt.Println("Note:\n'.' matches any single character\n'*' matches zero or more of the preceding element")
	fmt.Println("Input a pattern:  ")
	fmt.Scanf("%s", &str2)
	matched, _ := regexp.MatchString(str2, str1)
	fmt.Println(matched)
}
