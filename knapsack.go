package main
import (
	"fmt"
	"math"
)
func knapsack(capacity int,weight []int,profit []int,n int) int{
	if n==0||capacity==0{
		return 0
	}
	if weight[n-1]>capacity{
		return knapsack(capacity,weight,profit,n-1)
	}
	return int(math.Max(float64(profit[n-1]+knapsack(capacity-weight[n-1],weight,profit,n-1)),float64(knapsack(capacity,weight,profit,n-1))))
}
func main() {
	var n,capacity,total int
	var weight []int
	var profit []int
	fmt.Printf("Enter the no of vertices: ")
	fmt.Scanf("%d",&n)
	weight=make([]int,n)
	profit=make([]int,n)
	for i:=0;i<n;i++{
		fmt.Printf("Enter the weight and profit for %d object:\n ",i+1)
		fmt.Scanf("%d",&weight[i])
		fmt.Scanf("%d",&profit[i])
	}
	fmt.Printf("Enter the capacity of knapsack: \n")
	fmt.Scanf("%d",&capacity)

	total=knapsack(capacity,weight,profit,n)
	fmt.Printf("\nMaximum profit is: %d \n",total)
}
