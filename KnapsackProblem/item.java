package KnapsackProblem;

public class item {
	public int value;
	public int weight;
	
	public item() {
		this.value = 0;
		this.weight = 0;
	}
	
	public item(int v, int w) {
		this.value = v;
		this.weight = w;
	}
	
	public item(item a) {
		this.value = a.value;
		this.weight = a.weight;
	}
}
