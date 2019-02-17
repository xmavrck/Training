package main
import "fmt"
func main(){
	var n1,n2 int
	var c=0
	var flag=0
	fmt.Print("Enter first number: ")
	fmt.Scanf("%d",&n1)
	fmt.Print("Enter second number: ")
	fmt.Scanf("%d",&n2)
	fmt.Println("Enter number between 1 to 7")
	var x int
	fmt.Scanf("%d",&x)
	switch x{
	case 1:
		fmt.Println("And operation is:",n1&n2)
	case 2:
		fmt.Println("Or operation is:",n1|n2)
	case 3:
		fmt.Println("Xor operation is:",n1^n2)
	case 4:
		fmt.Println("Is even?")
		if n1%2==0{
			fmt.Println(n1,"is even")
		}
		if n2%2==0{
			fmt.Println(n2,"is even")
		}
	case 5:
		fmt.Println("Is positive?")
		if n1<0{
			fmt.Println(n1,"is positive")
		}
	case 6:
		fmt.Println("Count set bit:")
		for n1!=0{
			if n1&1==1{
				c++
			}
			n1=n1>>1
		}
	case 7:
		fmt.Println("Is power of two?")
		temp:=n1
		for temp!=1{
			if temp%2!=0{
				flag=1
			}
			temp=temp/2
		}
		if flag==0{
			fmt.Println(n1,"is in power of 2")
		} else {
			fmt.Println(n1,"is not in power of 2")
		}
	}
}
