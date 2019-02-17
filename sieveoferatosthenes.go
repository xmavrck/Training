package main
import "fmt"
func main(){
	var n int
	i:=5
	c:=2
	var f int
	fmt.Printf("Enter the range of prime number required: ")
	fmt.Scanf("%d",&n)
	array:=make([]int,n)
	array[0]=2
	array[1]=3
	for i <= n{
		f=1
		for j:=0;j<c&&array[j]*array[j]<=i;j++{
			if i%array[j]==0{
				f=0
				break
			}
		}
		if f>0{
			array[c]=i
			c++
		}
		i++
	}
	fmt.Printf("Prime number upto %d are: ",n)
	for i:=0;i<c;i++{
		fmt.Print(array[i])
		fmt.Print(" ")
	}
	fmt.Printf("\nTotal Prime numbers are %d: ",c)
}
