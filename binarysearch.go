package main
import "fmt"
func binarysearch(a []int,low int,high int,search int) int{
  if high>=low{
    var mid int=low+(high-low)/2
    if a[mid]==search{
      return mid
    } else if a[mid]>search{
      return binarysearch(a,low,mid-1,search)
    }
    return binarysearch(a,mid+1,high,search)
  }
  return -1
}
func main(){
  var n, result int
  fmt.Print("Enter number of elements: ")
  fmt.Scanf("%d",&n)
  var a=make([]int,n)
  for i:=0;i<n;i++{
    fmt.Scanf("%d",&a[i])
  }
  var search int
  fmt.Print("Enter the number to be searched: ")
  fmt.Scanf("%d",&search)
  result=binarysearch(a,0,n-1,search)
  if result==-1{
    fmt.Println("Not Found")
  } else{
    fmt.Println("Search Position:",result+1);
  }
}
