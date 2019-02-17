package DataStructure;

import java.util.Scanner;

public class SegmentTree {
	int[] tArr;
	String funct;
	
	public SegmentTree(int[] seq, int n){
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
		int max_size = 2 * (int) Math.pow(2, x) - 1; 
		tArr = new int[max_size]; // Memory allocation 
		constructST(seq, 0, n - 1, 0);
	}

	private int constructST(int[] seq, int start, int end, int index) {
		if(start == end) {
			this.tArr[index] = seq[start];
			return seq[start];
		}
		int mid = (end + start) / 2; 
		try {
			this.tArr[index] = mainFunc(this.funct, constructST(seq, start, mid, index * 2 + 1), 
				constructST(seq, mid + 1, end, index * 2 + 2)); 
		}
		catch(Exception e) {
			
		}
		return this.tArr[index];
	}
	
	private int mainFunc(String st, int a, int b) throws Exception {
		if(st.equals("Add")) {
			return a+b;
		}
		else if(st.equals("Min")) {
			return Math.min(a, b);
		}
		else if(st.equals("Max")) {
			return Math.max(a, b);
		}
		throw new Exception("Invalid mainFunc");
	}
	
	public int getSub(int start, int end, int qryStart, int qryEnd, int index) throws Exception {
		if(qryStart <= start && qryEnd >= end) {
			// main range is our query range whose sum is at index
			return this.tArr[index];
		}
		if(end < qryStart || start > qryEnd) {
			// query range is out side our main range
			return 0;
		}
		// query range is part of our main range
		int mid = (end+start)/2;
//		return getSum(start, mid, qryStart, qryEnd, 2*index+1) +
//				getSum(mid+1, end, qryStart, qryEnd, 2*index+2);
		return mainFunc(this.funct, 
					getSub(start, mid, qryStart, qryEnd, 2*index+1), 
					getSub(start, mid, qryStart, qryEnd, 2*index+1)
				);
	}
	
	public void update(int[] seq, int index, int new_val, int start, int end, int pt) throws Exception {
		if(index < start|| index > end) {
			return;
		}
		if(start == end) {
			this.tArr[pt] = seq[index];
			return;
		}
		int mid = (end+start)/2;
		if(index <= mid) {
			update(seq, index, new_val, start, mid, 2*pt+1);
		}else {
			update(seq, index, new_val, mid+1, end, 2*pt+2);
		}
		this.tArr[pt] = mainFunc(this.funct, this.tArr[2*pt+1], this.tArr[2*pt+2]);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		int size = scan .nextInt();
		int[] seq = new int[size];
		for(int i=0; i<size; i++) {
			seq[i] = scan.nextInt();
		}
		SegmentTree tree = new SegmentTree(seq, size);
		String input;
		String[] inpSplit;
		int noQry = scan.nextInt();
		for(int i = 0; i<noQry; i++){
			input = scan.nextLine();
			inpSplit = input.split(",");
			if(inpSplit[0].equals("Get")) {
				System.out.println(
						tree.getSub(0, size-1, Integer.parseInt(inpSplit[1]), Integer.parseInt(inpSplit[2]), 0)
					);
			}else {
				tree.update(seq, Integer.parseInt(inpSplit[1]), Integer.parseInt(inpSplit[2]),
						0, seq.length-1, 0);
				System.out.println(
						tree.getSub(0, size-1, Integer.parseInt(inpSplit[1]), Integer.parseInt(inpSplit[2]), 0)
					);
			}
		}
		scan.close();
	}
}
