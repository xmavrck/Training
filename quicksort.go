package main
import(
	"fmt"
	"math/rand"
)
func main(){
	var n int
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d",&n)
	array:=make([]int,n)
	for i:=0;i<n;i++{
		fmt.Scanf("%d ",&array[i])
	}
	fmt.Println("\nUnsorted\n",array)
	quicksort(array)
	fmt.Println("Sorted\n",array)
}
func quicksort(array []int) []int{
	if len(array)<2{
		return array
	}
	left,right:=0,len(array)-1
	pivot:=rand.Int()%len(array)
	array[pivot],array[right]=array[right],array[pivot]
	for i:=range array{
		if array[i]<array[right]{
			array[left],array[i]=array[i],array[left]
			left++
		}
	}
	array[left],array[right]=array[right],array[left]
	quicksort(array[:left])
	quicksort(array[left+1:])
	return array
}
