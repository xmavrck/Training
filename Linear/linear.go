package main
import "fmt"
func main() {
  var x int
  var n int
  var i int
  fmt.Printf("enter the size of array:")
  fmt.Scanf("%d ", &n)
  a := make([]int, n)
  fmt.Printf("enter the element in array:")
  for i = 0; i < n ; i++{
      fmt.Scanf("%d ", &a[i])
  }
  fmt.Printf("enter the element to search: ")
  fmt.Scanf("%d ",&x)
    for i = 0 ; i<n ; i++  {
    if a[i] == x{
      break
    }
  }
  if i<n{
    fmt.Printf("number is found at index %d",i)
  }  else {
      fmt.Printf("element not found")
  }
}
