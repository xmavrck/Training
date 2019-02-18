package main
import "fmt"
func combination(alphabet string,length int)<-chan string{
	c:=make(chan string)
	go func(c chan string){
		defer close(c)
		addAlphabet(c,"",alphabet,length)
	}(c)
	return c
}
func addAlphabet(c chan string,combo string,alphabet string,length int){
	if length<=0{
		return
	}
	var newCombo string
	for _,ch:=range alphabet{
		newCombo=combo+string(ch)
		c<-newCombo
		addAlphabet(c,newCombo,alphabet,length-1)
	}
}
func main(){
	var str string
	var length int
	fmt.Printf("Enter a string for getting combinations: \n")
	fmt.Scanf("%s",&str)
	fmt.Printf("Enter the length to which combinations are required: \n")
	fmt.Scanf("%d",&length)
	for combination:=range combination(str,length){
		fmt.Print(" '",combination,"' ")
	}
	fmt.Printf("\n")
}
