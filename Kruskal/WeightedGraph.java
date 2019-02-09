package Kruskal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class WeightedGraph{
    public int noVertices;
    public ArrayList<Edge> edges;

    public WeightedGraph(int noVer){
        this.noVertices = noVer;
        this.edges = new ArrayList<Edge>();
        Scanner scan = new Scanner(System.in);
        String input;
        while(true){
                input = scan.nextLine();
                if(input.equals("") || input.equals(" ")) {
                        break;
                }
                else {
                        String[] inputSplit = input.split(",");
                        this.edges.add(new Edge(Integer.parseInt(inputSplit[0]), Integer.parseInt(inputSplit[1]), Integer.parseInt(inputSplit[2])));
                }
        }
        scan.close();
    }
    
    public WeightedGraph(ArrayList<Edge> ed) {
        this.edges = ed;
        HashSet<Integer> vertices = new HashSet<Integer>();
        for(Edge e: this.edges) {
                vertices.add(e.start);
                vertices.add(e.end);
        }
        this.noVertices = vertices.size();
    }
    
    public void swapEdges(int i, int j) {
        Edge temp = new Edge(this.edges.get(i));
        this.edges.set(i, new Edge(this.edges.get(j)));
        this.edges.set(j, new Edge(temp));
    }
    
    public void sortEdges() {
        int noEdges = this.edges.size();
        for(int i = 0; i < noEdges-1; i++) {
            for(int j = i+1; j < noEdges; j++) {
            	if(this.edges.get(i).weight > this.edges.get(j).weight) {
            		this.swapEdges(i, j);
            	}
            }
        }
    }
    
    public void showEdges() {
    	for(Edge e: this.edges) {
    		System.out.println(""+e.start+","+e.end+","+e.weight);
    	}
    	System.out.println("");
    }
}