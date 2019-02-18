package Trees;

import java.util.ArrayList;
import java.util.Scanner;

public class AvlTree {

	avlNode root;
	
	public class avlNode{
		public int data;
		public avlNode leftChild;
		public avlNode rightChild;
		public avlNode parent;
		public int height;
		
		public avlNode(int dt) {
			this.data = dt;
			this.leftChild = null;
			this.rightChild = null;
			this.parent = null;
			this.height = 0;
		}
		
		public avlNode(avlNode par) {
//			super();
			this.data = -100;
			this.leftChild = null;
			this.rightChild = null;
			this.parent = par;
			this.height = 0;
		}
		
		public avlNode(avlNode par, int a) {
//			super();
			this.data = a;
			this.leftChild = null;
			this.rightChild = null;
			this.parent = par;
			this.height = 0;
		}
	}
	
	public avlNode avlLeftLeft(avlNode x, avlNode y, avlNode z) {
		z.leftChild = x.rightChild;
		x.rightChild = z;
		
		x.parent = z.parent;
		z.leftChild.parent = z;
		x.rightChild.parent = x;
		
		return x;
	}
	
	public avlNode avlLeftRight(avlNode x, avlNode y, avlNode z) {
		x.rightChild = y.leftChild;
		z.leftChild = y.rightChild;
		y.leftChild = x;
		y.rightChild = z;
		
		y.parent = z.parent;
		x.rightChild.parent = x;
		z.leftChild.parent = z;
		x.parent = y;
		z.parent = y;
		return y;
	}
	
	public avlNode avlRightLeft(avlNode x, avlNode y, avlNode z) {
		z.rightChild = y.leftChild;
		x.leftChild = y.rightChild;
		y.rightChild = x;
		y.leftChild = z;
		
		y.parent = z.parent;
		x.parent = y;
		z.parent = y;
		z.rightChild.parent = z;
		x.leftChild.parent = x;
		
		return y;
	}
	
	public avlNode avlRightRight(avlNode x, avlNode y, avlNode z) {
		z.rightChild = x.leftChild;
		x.leftChild = z;
		
		x.parent = z.parent;
		z.rightChild.parent = z;
		x.leftChild.parent = x;
		return x;
	}
	
	public void avlPerform(avlNode y) {
		avlNode x = y.parent;
		avlNode z = x.parent;	
		avlNode par = z.parent;
		boolean left=false;
		if(par.leftChild == z) {
			left = true;
		}else {
			left = false;
		}
		avlNode res;
		// left left
		if(z.leftChild == x && x.leftChild == y) {
			res = avlLeftLeft(x, y, z);
		}
		//left right
		else if(z.leftChild == x && x.rightChild == y) {
			res = avlLeftRight(x, y, z);
		}
		// right left
		else if(z.rightChild == x && x.leftChild == y) {
			res = avlRightLeft(x, y, z);
		}
		// right right
		else{
			res = avlRightRight(x, y, z);
		}
		
		if(left) {
			par.leftChild = res;
		}else {
			par.rightChild = res;
		}
	}
	
	public boolean avlCheck(avlNode y) {
		avlNode x = y.parent;
		avlNode z = x.parent;
		if(Math.abs(z.rightChild.height - z.leftChild.height) >=2) {
			return true;
		}
		return false;
	}
	
	public void updateForefathers(avlNode a) {
		avlNode temp = a;
		int lh;
		int rh;
		while(temp != null) {
			if(temp.leftChild == null) {
				lh = -1;
			}else {
				lh = temp.leftChild.height;
			}
			
			if(temp.rightChild == null) {
				rh = -1;
			}else {
				rh = temp.rightChild.height;
			}
			temp.height = Math.max(lh, rh) + 1;
			if(avlCheck(temp)) {
				avlPerform(temp);
			}
			temp = temp.parent;
		}
	}
	
	public void avlInsert(avlNode t, int inp) {
		if(t.data > inp) {
			if(t.leftChild == null) {
				t.leftChild = new avlNode(t, inp);
				updateForefathers(t);
				
			}else {
				avlInsert(t.leftChild, inp);
			}
			
		}else {
			if(t.rightChild == null) {
				t.rightChild = new avlNode(t, inp);
				updateForefathers(t);
				
			}else {
				avlInsert(t.rightChild, inp);
			}
		}
	}
	
	public AvlTree(){
		Scanner scan = new Scanner(System.in);
		int noNodes = scan.nextInt();
		this.root = new avlNode(scan.nextInt());
		int inp;
		for(int i = 0; i<noNodes; i++) {
			inp = scan.nextInt();
			avlInsert(root, inp);
		}
		scan.close();
	}
	
	public void printBFS() {
		ArrayList <avlNode> que = new ArrayList<avlNode>();
		que.add(root);
		avlNode temp;
		while(!que.isEmpty()) {
			temp = que.remove(0);
//			perform function as wanted
			functionBFS(temp.data);
			if(temp.leftChild != null) {
				que.add(temp.leftChild);
			}
			if(temp.rightChild != null) {
				que.add(temp.rightChild);
			}
		}
	}
	
	public void functionBFS(int a) {
		System.out.print(""+a+"  ");
	}
	
	public static void main(String[] args) {
		AvlTree t = new AvlTree();
		t.printBFS();
	}
}
