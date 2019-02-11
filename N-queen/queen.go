package main
import (
  "math"
  "fmt" )

var count int
var board [4]int

func print(n float64) {
var i float64
count := 0
var j float64
fmt.Printf("solution:\n\n")
count++
for i = 1 ; i <= n ; i ++ {
  fmt.Printf("%f",i)
}
  for i = 1 ; i<= n ;i++{
      fmt.Printf("%v",i)
      for j=1;j<=n;j++{
        var a int = int(i)
        var b int = int(j)
          if board[a] == b {
              fmt.Printf("Q") // for queen at i,j position
          }
        }
    }
}

func place(row float64, column float64)int{
  var i float64
  for i = 1 ; i <= row ; i++{
    var y int = int(i)
    var z int = int(column)
         if board[y] == z{
        return 0
      } else {
        var a float64 = float64(i)
        k := math.Sqrt(a-column)
        if k == math.Sqrt(i-row){
          return 0

        }
    }
}
return 1
}

func queen(row float64, n float64) {
  var column float64
  for column =1 ; column <= n ; column++  {
      if place(row, column)>0{
        var y int = int(row)
        var z int = int(column)
          board[y] = z
          if row == n {
              fmt.Print(n)
          } else {
            go queen(row+1,n)
          }
        }
    }
}


func main(){
  var n float64
  fmt.Printf("enter number of queens: ")
  fmt.Scanf("%f", &n)
  go queen(1.0,n)
}
