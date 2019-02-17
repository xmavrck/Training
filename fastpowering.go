package main
import "fmt"
func fastpower(n int, power int) int{
  if(power==0){
    return 1;
  }
  return n*fastpower(n,power-1)
}
func main(){
	var n,power int
	fmt.Print("Enter number: ")
	fmt.Scanf("%d",&n)
	fmt.Print("Enter power: ")
	fmt.Scanf("%d",&power)
	result:=fastpower(n,power)
	fmt.Println(result)
}
