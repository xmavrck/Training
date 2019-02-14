package BellmanFord;

public class Edge {
	public int from;
	public int to;
	public int weight;
	
	public Edge(int f, int t, int w) {
		this.from = f;
		this.to = t;
		this.weight = w;
	}
}
