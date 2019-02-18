package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func hamming(str1 string, str2 string) {
	p := strings.Split(str1, "")
	t := strings.Split(str2, "")
	var count = 0
	for i := 0; i < len(p); i++ {
		if p[i] != t[i] {
			count++
		}
	}
	fmt.Printf("%d\n", count)

}
func main() {
	reader := bufio.NewReader(os.Stdin)
	fmt.Println("Enter string : ")
	str1, _ := reader.ReadString('\n')
	fmt.Println("Enter the string to be matched: ")
	str2, _ := reader.ReadString('\n')
	if len(str1) == len(str2) {
		hamming(str1, str2)
	} else {
		fmt.Println("\nstrings are not equal ")
	}

}
