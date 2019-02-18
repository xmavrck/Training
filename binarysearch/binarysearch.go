package main
import "fmt"
var arr []int
var n, key int
func main() {
  var n int
  var i int
  var x int
  var flag = 0
  var mid int
  fmt.Printf("Enter the of array:\n")
  fmt.Scanf("%d ", &n)
  arr = make([]int, n)
fmt.Printf("Enter the sorted element in the array:\n")
for i = 0; i < n; i++ {
  fmt.Scanf("%d ", &arr[i])
}
  fmt.Print("\nenter the Element to search")
  fmt.Scanf("%d ", &x)
  var n2 = n-1
  var n1 =0
   for n1 <= n2 {
      mid = (n1 + n2 )/2
      if x == arr[mid] {
        flag = 1
        break
         } else {
           if x > arr[mid]  {
               n1 = mid + 1
             } else {
               n2 = mid - 1
             }

          }

      }

      if flag == 1 {
        fmt.Printf("\nElement found at position %d", mid +1)
      } else {
          fmt.Printf("\nElement not found")
      }
   }
