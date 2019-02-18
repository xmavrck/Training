function floydWarshall(graph) 
{
  let dist=[];
  let i,j,k;
  let V=4;
  let INF=99999;
	for(i=0;i<V;i++) 
		for(j=0;j<V;j++) 
			dist[i][j]=graph[i][j]; 
	for(k=0;k<V;k++) 
	{
		for(i=0;i<V;i++) 
		{ 
			for(j=0;j<V;j++) 
			{ 
				if(dist[i][k]+dist[k][j]<dist[i][j]) 
					dist[i][j]=dist[i][k]+dist[k][j]; 
			} 
		} 
	} 
	printSolution(dist); 
}

function printSolution(dist) 
{ 
	let V=4;
	  let INF=99999;
  for(let i=0;i<V;i++) 
	{ 
		for(let j=0;j<V;j++) 
		{ 
			if(dist[i][j]==INF) 
        console.log(INF)
		else
        console.log(dist[i][j])
		} 
	} 
} 
	
let graph=[
    [0, 5, INF, 10], 
		[INF, 0, 3, INF], 
		[INF, INF, 0, 1], 
		[INF, INF, INF, 0]];
	console.log(floydWarshall(graph)); 

	