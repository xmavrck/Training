package main
import "fmt"
var n int
var cost=0
var graph [][]int
var completed [10]int
func input(){
	fmt.Printf("Enter the size of matrix: ")
	fmt.Scanf("%d",&n)
	fmt.Printf("\nEnter the cost matrix: ")
	graph=make([][]int,n)
	for i:=0;i<n;i++{
		fmt.Printf("\nEnter the element in row %d:\n",i+1)
		graph[i]=make([]int,n)
		for j:=0;j<n;j++{
			fmt.Scanf("%d",&graph[i][j])
		}
		completed[i]=0
	}
	fmt.Printf("\nThe cost list is:\n")
	for i:=0;i<n;i++{
		fmt.Printf("\n")
		for j:=0;j<n;j++{
			fmt.Printf("%d\t",graph[i][j])
		}
	}
}
func least(c int) int{
	nc:=999
	min:=999
	var kmin int
	for i:=0;i<n;i++{
		if (graph[c][i]!=0)&&(completed[i])==0{
			if graph[c][i]+graph[i][c]<min{
				min=graph[i][0]+graph[c][i]
				kmin=graph[c][i]
				nc=i
			}
		}
	}
	if min!=999{
		cost+=kmin
	}
	return nc
}
func mincost(city int){
	var ncity int
	completed[city]=1
	fmt.Printf("%d-->",city+1)
	ncity=least(city)
	if ncity==999{
		ncity=0
		fmt.Printf("%d",ncity+1)
		cost+=graph[city][ncity]
		return
	}
	mincost(ncity)
}
func main(){
	input()
	fmt.Printf("\nThe path is:\n")
	mincost(0)
	fmt.Printf("\nminimum cost is %d: ",cost)
}
