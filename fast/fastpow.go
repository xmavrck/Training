package main
import(
  "fmt"
)
func power(n int, p int) int {
  if p==0{
    return 1
  } else{
    return n*power(n,p-1)
  }
}
func main()  {
  var n, p int
  fmt.Scanf("%d\n%d", &n, &p)
  result := power(n,p)
  fmt.Printf("%d",result)
}
