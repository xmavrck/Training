package HamiltonianCycle;

import java.util.Scanner;
import java.util.ArrayList;

public class Graph {
	int noVertices;
	boolean[][] adjMatrix;
	
	public Graph(int noVer) {
		this.noVertices = noVer;
		this.adjMatrix = new boolean[noVer][noVer];
		Scanner scan = new Scanner(System.in);
		String input;
		while(true){
            input = scan.nextLine();
            if(input.equals("") || input.equals(" ")) {
                    break;
            }
            else {
                    String[] inputSplit = input.split(",");
                    this.adjMatrix[Integer.parseInt(inputSplit[0])-1][Integer.parseInt(inputSplit[1])-1] = true;
                    this.adjMatrix[Integer.parseInt(inputSplit[1])-1][Integer.parseInt(inputSplit[0])-1] = true;
            }
		}
	    scan.close();
    }
	
	public ArrayList<Integer> adjts(int node){
		ArrayList<Integer> adjs = new ArrayList<Integer>();
		for(int i=0; i<this.noVertices; i++) {
			if(this.adjMatrix[node][i]) {
				adjs.add(i);
			}
		}
		return adjs;
	}
}
