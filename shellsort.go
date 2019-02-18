package main
import "fmt"
var n int
var array []int
func search(array []int,n int){
	var gap,i,j,temp int
	for gap=n/2;gap>0;gap/=2{
		for i=gap;i<n;i++{
			temp=array[i]
			for j=i;j>=gap&&array[j-gap]>temp;j-=gap{
				array[j]=array[j-gap]
			}
			array[j]=temp
		}
	}
}
func main(){
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d",&n)
	array=make([]int,n)
	fmt.Printf("Enter the element in the array:\n")
	for i:=0;i<n;i++{
		fmt.Scanf("%d ",&array[i])
	}
	search(array,n)
	fmt.Printf("\nSorted array:\n")
	for i:=0;i<n;i++{
		fmt.Printf("%d ",array[i])
	}
}
