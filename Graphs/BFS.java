package Graphs;

import java.util.ArrayList;
import java.util.Scanner;
import HamiltonianCycle.Graph;

public class BFS {
	
	static Graph g;
	
	public static ArrayList<Integer> neighbours(int node) {
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		for(int i = 0; i<g.noVertices; i++) {
			if(g.adjMatrix[node][i]) {
				neighbours.add(i);
				for(int j = 0; j<g.noVertices; j++) {
					g.adjMatrix[j][i] = false;
				}
			}
		}
		return neighbours;
	}
	
	public static ArrayList<Integer> bfsGraph(){
		ArrayList<Integer> path = new ArrayList<Integer>();
		ArrayList<Integer> que = new ArrayList<Integer>();
		que.add(0);
		for(int i = 0; i<g.noVertices; i++) {
			g.adjMatrix[i][0] = false;
		}
		while(!que.isEmpty()) {
			path.add(que.get(0));
			que.addAll(neighbours(que.remove(0)));
		}
		return path;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noVer = scan.nextInt();
		g = new Graph(noVer);
		ArrayList<Integer> path = bfsGraph();		
		for(int i: path) {
			System.out.println(i);
		}
		scan.close();
	}
	
}
