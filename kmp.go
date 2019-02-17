package main
import (
	"bufio"
	"fmt"
	"os"
	"strings"
)
func compute(pat string,M int,lps []int) {
	length:=0
	lps[0]=0
	i:=1
	for i<M{
		if pat[i]==pat[length]{
			length++
			lps[i]=length
			i++
		} else{
			if length!=0{
				length=lps[length-1]
			} else{
				lps[i]=0
				i++
			}
		}
	}
}
func kmp(pat string,txt string) {
	p:=strings.Split(pat, "")
	t:=strings.Split(txt, "")
	M:=len(p)
	N:=len(t)
	lps:=make([]int,M)
	compute(pat,M,lps)
	i:=0
	j:=0
	for i<N{
		if p[j]==t[i]{
			j++
			i++
		}
		if j==M{
			fmt.Printf("Found pattern at index %d",i-j)
			j=lps[j-1]
		} else if i<N&&p[j]!=t[i]{
			if j!=0{
				j=lps[j-1]
			}else{
				i=i+1
			}
		}
	}
}
func main() {
	reader:=bufio.NewReader(os.Stdin)
	fmt.Println("Enter string : ")
	txt, _:=reader.ReadString('\n')
	fmt.Println("Enter the string to be matched: ")
	pat, _:=reader.ReadString('\n')
	kmp(pat,txt)
}
