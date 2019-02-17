package Heap;

import java.util.ArrayList;
import java.util.Scanner;

public class Heap {

	public ArrayList<Integer> heap;
	String type;
	
	public Heap(String st) {
		heap = new ArrayList<Integer>();
		this.type = st;
	}
	
	public void insert(int inp) {
		if(this.heap.isEmpty()) {
			this.heap.add(inp);
		}else {
			this.heap.add(this.heap.size(), inp);
		}
		heapify(this.heap.size()-1);
	}
	
	private boolean mainFunc(int a, int b) {
		if(this.type == "min") {
			return a<b;
		}
		else {
			return a>b;
		}
	}
	
	private void heapify(int index) {
		int a;
		int b;
		while(index>0) {
			a = this.heap.get((index-1)/2);
			b = this.heap.get(index);
			if(!mainFunc(a, b)) {
				this.heap.set((index-1)/2, b);
				this.heap.set(index, a);
			}
			index = (index-1)/2;
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Heap h = new Heap("min");
		String inp;
		while(true) {
			inp = scan.nextLine();
			if(inp.equals("") || inp.equals(" ")) {
				break;
			}else {
				h.insert(Integer.parseInt(inp));
			}
		}
		for(int i: h.heap) {
			System.out.println(i);
		}
		scan.close();
	}

}
