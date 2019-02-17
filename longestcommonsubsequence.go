package main
import(
	"fmt"
	"math"
)
func lcs(x string,y string,m int,n int) int{
	if m==0||n==0{
		return 0
	}
	if x[m-1]==y[n-1]{
		return 1 + lcs(x,y,m-1,n-1)
	}
	return int(math.Max(float64(lcs(x,y,m,n-1)),float64(lcs(x,y,m-1,n))))
}
func main(){
	var str1,str2 string
	fmt.Print("Input first string: ")
	fmt.Scanf("%s",&str1)
	fmt.Print("Input second string: ")
	fmt.Scanf("%s",&str2)
  m:=len(str1)
  n:=len(str2)
	res:=lcs(str1,str2,m,n)
	fmt.Println("\nLength of LCS is",res)
}
