package main
import(
	"fmt"
	"strings"
)
func hamming(str1 string,str2 string){
	p:=strings.Split(str1,"")
	t:=strings.Split(str2,"")
	var count=0
	for i:=0;i <len(p);i++{
		if p[i]!=t[i]{
			count++
		}
	}
	fmt.Printf("Hamming Distance: %d",count)
}
func main(){
  var str1,str2 string
	fmt.Print("Enter string: ")
  fmt.Scanf("%s",&str1)
  fmt.Print("Enter the string to be matched: ")
  fmt.Scanf("%s",&str2)
	if len(str1)==len(str2){
		hamming(str1,str2)
	}else{
		fmt.Println("\nstrings are not equal")
	}
}
