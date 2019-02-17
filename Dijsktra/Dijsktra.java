package Dijsktra;
import java.util.Scanner;
import Kruskal.WeightedGraph;

public class Dijsktra {
	public static WeightedGraph g;
	
	private int minDistance(int dist[], boolean[] sptSet) {
        int min = Integer.MAX_VALUE, min_index=-1; 
        for (int v = 0; v < g.noVertices; v++) {
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            }
        }
        return min_index; 
    }
	
	public void dijkstra(int src){ 
        int[] dist = new int[g.noVertices];
        boolean[] visitedNodes = new boolean[g.noVertices];
        for (int i = 0; i < g.noVertices; i++){
            dist[i] = Integer.MAX_VALUE;
            visitedNodes[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < g.noVertices-1; count++){ 
            int u = minDistance(dist, visitedNodes); 
            visitedNodes[u] = true; 
            for (int v = 0; v < g.noVertices; v++) {
            	if (!visitedNodes[v] && g.edgesMat[u][v]!=0 && 
                        dist[u] != Integer.MAX_VALUE && 
                        dist[u]+g.edgesMat[u][v] < dist[v]) { 
                    dist[v] = dist[u] + g.edgesMat[u][v]; 
                }
        	}
        } 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int noVer = scan.nextInt();
		g = new WeightedGraph(noVer, true);
		
		
		
		scan.close();
	}

}
