package Kruskal;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class kruskal {

	static ArrayList<HashSet<Integer>> acceptedVerticesSets;
	static ArrayList<Edge> acceptedEdges;
	
	public static int[] verticesInState(int a, int b) {
		int aInIndex = -1;
		int bInIndex = -1;
		for(HashSet<Integer> s: acceptedVerticesSets) {
			if(s.contains(a)) {
				aInIndex = acceptedVerticesSets.indexOf(s);
			}
			if(s.contains(b)) {
				bInIndex = acceptedVerticesSets.indexOf(s);
			}
		}
		int[] result = {-1, aInIndex, bInIndex};
		if(aInIndex == bInIndex && aInIndex != -1) {
//			are in same index
//			==	|  a!=-1  |  b!=-1
//			 1	|	 1    |    1    =>  7
			result[0] = 7;
		}else if(aInIndex == bInIndex) {
//			both are out
//			==	|  a!=-1  |  b!=-1
//			 1	|	 0    |    0    =>  4
			result[0] = 4;
		}else if(aInIndex != -1 && bInIndex != -1) {
//			both are present but in different sets
//			==	|  a!=-1  |  b!=-1
//			 0	|	 1    |    1    =>  3
			result[0] = 3;			
		}else if(aInIndex == -1){
//			b is present but a not
//			==	|  a!=-1  |  b!=-1
//			 0	|	 0    |    1    =>  1
			result[0] = 1;
		}else if(bInIndex == -1) {
//			a is present but b not
//			==	|  a!=-1  |  b!=-1
//			 0	|	 1    |    0    =>  2
			result[0] = 2;
		}else {
//			Should not happen
			result[0] = 100;
		}
		return result;
	}
	
	public static void mergeSets(int a, int b) {
		boolean r = acceptedVerticesSets.get(a).addAll(acceptedVerticesSets.get(b));
		if(r) {
			acceptedVerticesSets.remove(b);
		}else {
			System.out.println("Error In Merging!!");
		}
	}
	
	public static void main(String[] args) {
		// get the graph
		Scanner scan = new Scanner(System.in);
		int noVertices = scan.nextInt();
		WeightedGraph g = new WeightedGraph(noVertices);
		// sort the edges
		g.sortEdges();
		// list of (set of vertices) 		
		acceptedVerticesSets = new ArrayList<HashSet<Integer>>();
		acceptedEdges = new ArrayList<Edge>();
		// check for the state of the edge
		int[] check;
		for(Edge e: g.edges) {
			// if we get our result			
			if(acceptedVerticesSets.size() == 1 && acceptedVerticesSets.get(0).size() == 5) {
				break;
			}
			check = verticesInState(e.start, e.end);
			switch(check[0]) {
				case 1:
					// end is present and start is being accepted
					acceptedVerticesSets.get(check[2]).add(e.start);
					acceptedEdges.add(e);
					break;
				case 2:
					// start is present and end is being accepted
					acceptedVerticesSets.get(check[1]).add(e.end);
					acceptedEdges.add(e);
					break;
				case 3:
					// start and end both are present, but in different sets
					mergeSets(check[1], check[2]);
					acceptedEdges.add(e);
					break;
				case 4:
					// start and end, both are out of sets
					HashSet<Integer> s = new HashSet<Integer> ();
					s.add(e.start);
					s.add(e.end);
					acceptedVerticesSets.add(s);
					acceptedEdges.add(e);
					break;
				case 7:
					// start and end both are in same set
					break;
				default:
					System.out.println("Unexpected Error");
			}
		}
		System.out.println("Edges in Results are: ");
		for(Edge e: acceptedEdges) {
			System.out.println(""+e.start+","+e.end+","+e.weight);
		}
		//  can create weighted graph too
		//  WeightedGraph res = new WeightedGraph(acceptedEdges);
		scan.close();
	}

}
