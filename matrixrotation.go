package main
import "fmt"
var matrix [][]int
var n int
func input(){
	fmt.Printf("Enter the size of matrix: ")
	fmt.Scanf("%d",&n)
	matrix=make([][]int,n)
	for i:=0;i<n;i++{
		fmt.Printf("Enter the element in row %d\n",i+1)
		matrix[i]=make([]int,n)
		for j:=0;j<n;j++{
			fmt.Scanf("%d",&matrix[i][j])
		}
	}
}
func rotate(n int,matrix [][]int){
	var i,j int
	for i=0;i<n/2;i++{
		for j=0;j<n-i-1;j++{
			var temp=matrix[i][j]
			matrix[i][j]=matrix[j][n-1-i]
			matrix[j][n-1-i]=matrix[n-1-i][n-1-j]
			matrix[n-1-i][n-1-j]=matrix[n-1-j][i]
			matrix[n-1-j][i]=temp
		}
	}
}
func display(){
	for i:=0;i<n;i++{
		fmt.Printf("\n")
		for j:=0;j<n;j++{
			fmt.Printf("%d\t",matrix[i][j])
		}
	}
}
func main(){
	input()
	fmt.Printf("\nInputted Matrix :")
	display()
	rotate(n,matrix)
	fmt.Printf("\nMatrix after rotation:")
	display()
}
