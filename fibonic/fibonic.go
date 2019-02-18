package main
import {
    "fmt"
}
func main() {
    var a:= 0
    var b:= 1
    var c, n int
    fmt.Printf("\nEnter nmber of terms")
    fmt.Scanf("%d ",&n)
    for i=1 ; i < n ; i++ {
           c=a+b
           a=b
    }
    fmt.Printf("sum of series is : %d", c)
}
