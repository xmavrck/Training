package BellmanFord;

import java.util.ArrayList;
import java.util.Scanner;

public class BellmanFord {

	public static class WeightedGraph{
		ArrayList<Edge> edges = new ArrayList<Edge>();
		public WeightedGraph(int e){
			Scanner scan1 = new Scanner(System.in);
			System.out.println("Enter The edges(from, to, weight): ");
			String input;
			String[] inpSplit;
			for(int i=e; i>0; i--) {
				input = scan1.nextLine();
				inpSplit = input.split(",");
				edges.add(new Edge(Integer.parseInt(inpSplit[0]),
									Integer.parseInt(inpSplit[1]),
									Integer.parseInt(inpSplit[2])));
			}
			scan1.close();
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
//		Number of vertices
		System.out.println("No. Vertices: ");
		int v = scan.nextInt();
//		Set the distance array
		int[] dist = new int[v];
		for(int i = 0; i<v; i++) {
			dist[i] = (int) Double.POSITIVE_INFINITY;
		}
//		Number of edges
		System.out.println("No. Edges(vertices are 0-n): ");
		int e = scan.nextInt();
		System.out.println("Source: ");
		int s = scan.nextInt();
//		generate graph
		WeightedGraph g = new WeightedGraph(e);
		dist[s] = 0;
//		main computation
		boolean stateChanged;
		for(int i = 0; i<v-1; i++) {
			stateChanged = false;
			for(Edge edge: g.edges) {
				if(dist[edge.to]>(dist[edge.from]+edge.weight)) {
					dist[edge.to] = (dist[edge.from]+edge.weight);
					stateChanged = true;
				}
			}
			if(!stateChanged) {
				break;
			}
		}
//		Any negetive cycles
		for(Edge edge: g.edges) {
			if(dist[edge.to] != (int)Double.POSITIVE_INFINITY && dist[edge.to] > (dist[edge.from]+edge.weight)) {
				System.out.println("Edge from:"+edge.from+" to:"+edge.to+" is part of negetive cycle");
			}
		}
//		printing the solution
		for(int i = 0; i< dist.length; i++) {
			System.out.println(""+i+" -> "+dist[i]);
		}
		scan.close();
	}
}
