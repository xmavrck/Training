package main
import (
	"fmt"
	"math/rand"
)
func fisheryates(array []int,n int) []int{
	var temp int
	var random int
	for i:=n-1;i>0;i--{
		random=rand.Intn(n-1)
		temp=array[i]
		array[i]=array[random]
		array[random]=temp
	}
	return array
}
func main(){
	var n int
	var array []int
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d",&n)
	array=make([]int,n)
	fmt.Printf("Enter the element in the array:\n")
	for i:=0;i<n;i++{
		fmt.Scanf("%d",&array[i])
	}
	res:=fisheryates(array,n)
	fmt.Println(res)
}
