package main
import "fmt"
func main(){
	var n int
	fmt.Print("Enter range: ")
	fmt.Scanf("%d",&n)
	var f=make([]int,n)
	f[0]=0
	f[1]=1
	fmt.Printf("Fibonacci series upto %d terms are:\n",n)
	fmt.Printf("%d %d ",f[0],f[1])
	for i:=2;i<n;i++{
		f[i]=f[i-1]+f[i-2]
		fmt.Printf("%d ",f[i])
	}
}
