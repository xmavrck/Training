package main

 import "fmt"

  func main() {
          var a1, a2 []int
          var n1, n2 int
          fmt.Printf("enter the size of First array: ")
          fmt.Scanf("%d ", &n1)
          a1 = make([]int, n1)
          fmt.Printf("Enter the elements in First array:\n")
          for i := 0; i< n1; i++ {
                   fmt.Scanf("%d ", &a1[i])
          }

          fmt.Printf("enter the size of second array")
          fmt.Scanf("%d ", &n2)
          a2 = make([]int, n2)
          fmt.Printf("Enter the elements in second array:\n")
          for i := 0; i< n1; i++ {
                    fmt.Scanf("%d ", &a2[i])
          }
          cartprod(a1, a2, n1, n2)
}

  func cartprod(a1 []int, a2 []int, n1 int, n2 int) {
           for i :=0 ; i < n1 ; i++ {
           for j := 0 ; j < n2 ; j++ {
               fmt.Println("{", a1[i], ",", a2[j], "}")
           }
       }
  }
