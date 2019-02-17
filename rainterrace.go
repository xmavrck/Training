package main
import (
	"fmt"
	"math"
)
func rainTerrace(arr []int,n int) int{
	var left [10]int
	var right [10]int
	var water = 0
	left[0] = arr[0]
	for i:=1;i<n;i++{
		left[i]=int(math.Max(float64(left[i-1]),float64(arr[i])))
	}
	right[n-1]=arr[n-1]
	for i:=n-2;i>=0;i--{
		right[i]=int(math.Max(float64(right[i+1]),float64(arr[i])))
	}
	for i:=0;i<n;i++{
		water+=int(math.Min(float64(left[i]),float64(right[i])))-arr[i]
	}
	return water
}
func main(){
	var n int
	var array []int
	fmt.Printf("Enter the no of bars: ")
	fmt.Scanf("%d",&n)
	array=make([]int,n)
	fmt.Printf("Enter the bars to store water:\n")
	for i:=0;i<n;i++{
		fmt.Scanf("%d ",&array[i])
	}
	fmt.Println("We can trap ",rainTerrace(array,n)," units of water in the middle gap.")
}
