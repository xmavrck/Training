package main
import(
	"fmt"
	"math/rand"
)
const startRow=0
const startCol=0
func main(){
	for !knightTour(){
	}
}
var moves=[]struct{dr,dc int}{
	{2, 1},
	{2, -1},
	{1, 2},
	{1, -2},
	{-1, 2},
	{-1, -2},
	{-2, 1},
	{-2, -1},
}
func knightTour() bool{
	board:=make([][]int,8)
	for i:=range board{
		board[i]=make([]int,8)
	}
	r:=startRow
	c:=startCol
	board[r][c]=1
	for move:=2;move<=64;move++{
		minNext:=8
		var mr,mc,nm int
	candidateMoves:
		for _,cm:=range moves{
			cr:=r+cm.dr
			if cr<0||cr>=8{
				continue
			}
			cc:=c+cm.dc
			if cc<0||cc>=8{
				continue
			}
			if board[cr][cc]>0 {
				continue
			}
			p:=0
			for _,m2:=range moves{
				r2:=cr+m2.dr
				if r2<0||r2>=8{
					continue
				}
				c2:=cc+m2.dc
				if c2<0||c2>=8{
					continue
				}
				if board[r2][c2]>0{
					continue
				}
				p++
				if p>minNext{
					continue candidateMoves
				}
			}
			if p<minNext{
				minNext=p
				nm=1
				mr=cr
				mc=cc
				continue
			}
			nm++
			if rand.Intn(nm)==0{
				mr=cr
				mc=cc
			}
		}
		if nm==0{
			return false
		}
		r=mr
		c=mc
		board[r][c]=move
	}
	for _,r:=range board{
		for _,m:=range r{
			fmt.Printf("%d\t",m)
		}
		fmt.Println()
	}
	return true
}
