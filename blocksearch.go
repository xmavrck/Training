package main
import (
	"fmt"
	"math"
)
func jumpSearch(arr []int,x int,n int) int{
	var step=int(math.Sqrt(float64(n)))
	var prev=0
	for arr[int(math.Min(float64(step),float64(n))-1)]<x{
		prev=step
		step+=int(math.Sqrt(float64(n)))
		if prev>=n{
			return -1
		}
	}
	for arr[prev]<x{
		prev++
		if prev==int(math.Min(float64(step),float64(n))){
			return -1
		}
	}
	if arr[prev]==x{
		return prev
	}
	return -1
}
func main(){
	var n,key int
	var array []int
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d",&n)
	array=make([]int,n)
	fmt.Printf("Enter the sorted element in the array:\n")
	for i:=0;i<n;i++{
		fmt.Scanf("%d ",&array[i])
	}
	fmt.Printf("\nEnter the element to be searched: ")
	fmt.Scanf("%d",&key)
	fmt.Println("Fount at index",jumpSearch(array,key,n))
}
