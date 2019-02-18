package main
import (
	"fmt"
	"os"
)
var max=100
var initial=1
var waiting=2
var visited=3
var n int
var adj [100][100]int
var state [100]int
var queue [100]int
var front=-1
var rear=-1
func main(){
	creategraph()
	bfsTraversal()
}
func insertqueue(vertex int){
	if rear==max-1{
		fmt.Println("Queue Overflow")
	} else{
		if front==-1{
			front=0
		}
		rear=rear+1
		queue[rear]=vertex
	}
}
func bfs(v int){
	var i int
	insertqueue(v)
	state[v]=waiting
	for isEmptyqueue()==0{
		v=deletequeue()
		fmt.Printf("%d ",v)
		state[v]=visited
		for i=0;i<n;i++{
			if adj[v][i]==1&&state[i]==initial{
				insertqueue(i)
				state[i]=waiting
			}
		}
	}
	fmt.Printf("\n")
}
func bfsTraversal(){
	var v int
	for v=0;v<n;v++{
		state[v]=initial
	}
	fmt.Println("Enter Start Vertex for BFS:")
	fmt.Scanf("%d",&v)
	bfs(v)
}
func isEmptyqueue() int{
	if front==-1||front>rear{
		return 1
	}
	return 0
}
func deletequeue() int{
	var deleteitem int
	if front==-1||front>rear{
		fmt.Println("Queue Underflow")
		os.Exit(3)
	}
	deleteitem=queue[front]
	front=front+1
	return deleteitem
}
func creategraph(){
	var count,maxedge,origin,destin int
	fmt.Printf("Enter number of vertices: ")
	fmt.Scanf("%d",&n)
	maxedge=n*(n-1)
	for count=1;count<=maxedge;count++{
		fmt.Printf("Enter edge %d( -1 -1 to quit ): ",count)
		fmt.Scanf("%d",&origin)
		fmt.Scanf("%d",&destin)
		if (origin==-1)&&(destin==-1){
			break
		}
		if origin>=n||destin>=n||origin<0||destin<0{
			fmt.Printf("Invalid edge!\n")
			count--
		} else{
			adj[origin][destin]=1
		}
	}
}
