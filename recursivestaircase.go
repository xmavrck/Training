package main
import "fmt"
func staircase(x int) int {
	if x<= 1{
		return x
	}
	return staircase(x-1)+staircase(x-2)
}
func count(x int) int{
	return staircase(x+1)
}
func main(){
	var n int
	fmt.Print("Enter no. of staircase: ")
	fmt.Scanf("%d",&n)
	fmt.Println("No. of ways:",count(n))
}
