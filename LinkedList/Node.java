package LinkedList;

public class Node {
	int data;
	Node next;
	
	public Node(int d) {
		this.data = d;
		this.next = null;
	}
	
	public Node(int d, Node n) {
		this.data = d;
		this.next = n;
	}
}
