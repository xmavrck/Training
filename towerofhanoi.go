package main
import "fmt"
type toh struct{
}
type my interface{
	move(int,int,int,int)
}
func(t*toh)move(n,from,to,via int){
	if n==1{
		fmt.Println("Move disk from rod",from,"to rod",to)
	} else{
		t.move(n-1,from,via,to)
		fmt.Println("Move disk from rod",from,"to rod",to)
		t.move(n-1,via,to,from)
	}
}
func main(){
	var t my
	t=new(toh)
	var n int
	fmt.Printf("Enter the number of discs to be moved: ")
	fmt.Scanf("%d",&n)
	t.move(n,1,2,3)
}
