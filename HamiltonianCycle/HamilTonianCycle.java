package HamiltonianCycle;

import java.util.Scanner;
import java.util.ArrayList;

public class HamilTonianCycle {
	public static ArrayList<Integer> cycle;
	public static Graph g;
	
	public static boolean hamiCycle(int node) {
		cycle.add(node);
		if((cycle.size() == g.noVertices) &&
				(g.adjMatrix[cycle.get(0)][node])) {
			return true;
		}
		ArrayList<Integer> adjs = g.adjts(node);
		for(int nextNode: adjs) {
			if(cycle.contains(nextNode)) {
				continue;
			}
			if(hamiCycle(nextNode)) {
				return true;
			}			
		}
		cycle.remove(cycle.size()-1);
		return false;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int noVer = scan.nextInt();
		g = new Graph(noVer);
		int InitialNode = 0;
		cycle = new ArrayList<Integer> ();
		if(hamiCycle(InitialNode)) {
			for(int node : cycle) {
				System.out.print(""+(node+1)+" -> ");
			}
			System.out.println(cycle.get(0)+1);
		}else {
			System.out.println("Sorry! No Hamilton Cycle.");
		}
		scan.close();	
	}
}
