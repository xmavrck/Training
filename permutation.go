package main
import "fmt"
func permutations(arr []int) [][]int{
	var helper func([]int,int)
	res:=[][]int{}
	helper=func(arr []int,n int){
		if n==1{
			tmp:=make([]int,len(arr))
			copy(tmp,arr)
			res=append(res,tmp)
		}else{
			for i:=0;i<n;i++{
				helper(arr,n-1)
				if n%2==1{
					tmp:=arr[i]
					arr[i]=arr[n-1]
					arr[n-1]=tmp
				}else{
					tmp:=arr[0]
					arr[0]=arr[n-1]
					arr[n-1]=tmp
				}
			}
		}
	}
	helper(arr,len(arr))
	return res
}
func main(){
	var n int
	var array []int
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d",&n)
	array=make([]int,n)
	fmt.Printf("Enter the element in the array:\n")
	for i:=0;i<n;i++{
		fmt.Scanf("%d ",&array[i])
	}
	fmt.Printf("\nPermutations are:\n")
	for _, a:=range permutations(array) {
		fmt.Println(a)
	}
}
