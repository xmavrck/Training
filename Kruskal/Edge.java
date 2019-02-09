package Kruskal;

public class Edge{
    public int start;
    public int end;
    public int weight;
    
    public Edge() {
        this.start = 0;
        this.end = 0;
        this.weight = 0;
    }
    
    public Edge(int s, int e, int w) {
        this.start = s;
        this.end = e;
        this.weight = w;
    }
    
    public Edge(Edge e) {
        this.start = e.start;
        this.end = e.end;
        this.weight = e.weight;
    }
}
