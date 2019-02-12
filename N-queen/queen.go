package main
import (
  "fmt"
 )

var count int = 0
var board [20]int

//function will print the solution
func print(n int) {
var i int
var j int
count += 1
fmt.Printf("\nsolution: %d\n", count)

for i = 1 ; i <= n ; i++ {
  fmt.Printf("\t%d",i)
}
  for i = 1 ; i <= n ;i++ {
      fmt.Printf("\n%d\t",i)
      for j = 1; j <=n ; j++{ //to make a square matrix
          if board[i] == j {
              fmt.Printf("Q\t") // for queen at i,j position
          } else {
            fmt.Printf("-\t") // no queen placed
          }
        }
    }
}
// function will check the queen to be placed or not
func place(row int, column int)int{

  var i int
  for i = 1 ; i <= (row-1) ; i++{
      if board[i] == column{
           return 0
      } else if (board[i]-column) == (i-row) || (board[i]-column) == -(i-row) {
          return 0
        }
}
return 1
}

func queen(row int, n int) {
  var column int
  for column = 1 ; column <= n ; column++  {
      if place(row, column) > 0{
          board[row] = column
          if row == n {  //at the end of the matrix
              print(n)  // print the queen allignment
          } else { //will try for the next position
            queen(row+1,n)
          }
        }
    }
}
func main(){
  var n int
  fmt.Printf("N-QUEEN PROBLEM")
  fmt.Printf("Enter The Number of Queens: ")
  fmt.Scanf("%d", &n)
  queen(1,n)
}
