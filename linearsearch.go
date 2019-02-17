package main
import "fmt"
func main(){
  var n int
  fmt.Print("Enter number of elements: ")
  fmt.Scanf("%d",&n)
  var a=make([]int, n)
  for i:=0;i<n;i++{
    fmt.Scanf("%d",&a[i])}
  var search int
  fmt.Print("Enter the number to be searched: ")
  fmt.Scanf("%d",&search)
  flag:=0
  for i:=0;i<n;i++{
    if search==a[i]{
      fmt.Println("Search Position:",i+1)
      flag=1;
      break;}
  }
  if flag==0{
    fmt.Println("Not Found")}
}
