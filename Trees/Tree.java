package Trees;
import java.util.Scanner;
import java.util.ArrayList;

public class Tree {
	TreeNode root;	
	
	private void setTreeByBFS(ArrayList<Integer> arr) {

		ArrayList<TreeNode> que = new ArrayList<TreeNode>();
		root = new TreeNode(arr.remove(0));
		que.add(root);
		TreeNode temp;
		while(!arr.isEmpty()) {
			temp = que.remove(0);
			temp.leftChild = new TreeNode(arr.remove(0), temp);
			que.add(temp.leftChild);
			if(!arr.isEmpty()) {
				temp.rightChild = new TreeNode(arr.remove(0), temp);
				que.add(temp.rightChild);
			}
		}
		que.clear();
	}
	
	public void setBiTree(TreeNode t, int inp) {
		if(inp < t.data) {
			if(t.leftChild == null) {
				t.leftChild = new TreeNode(inp, t);
			}else {
				setBiTree(t.leftChild, inp);
			}
		}else {
			if(t.rightChild == null) {
				t.rightChild = new TreeNode(inp, t);
			}else {
				setBiTree(t.rightChild, inp);
			}
		}
	}
	
	public Tree(boolean bi) {
		if(!bi) {
			Scanner scan = new Scanner(System.in);
			ArrayList<Integer> treeData = new ArrayList<Integer>();
			String input = scan.nextLine();
			String[] inputSplit = input.split(",");
			for(int i = 0; i<inputSplit.length; i++) {
				treeData.add(Integer.parseInt(inputSplit[i]));
			}
			this.setTreeByBFS(treeData);
			scan.close();
		}else {
			Scanner scan = new Scanner(System.in);
			int noNodes = scan.nextInt();
			this.root = new TreeNode(scan.nextInt());
			int inp;
			for(int i = 0; i<noNodes; i++) {
				inp = scan.nextInt();
				setBiTree(root, inp);
			}
			scan.close();
		}
	}
		
	public void printBFS() {
		ArrayList <TreeNode> que = new ArrayList<TreeNode>();
		que.add(root);
		TreeNode temp;
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
	
	public void inorder(TreeNode t) {		
		if(t.leftChild != null) {
			inorder(t.leftChild);
		}
		System.out.println(t.data);
		if(t.rightChild != null) {
			inorder(t.rightChild);
		}
	}
	
	public void preorder(TreeNode t) {		
		System.out.println(t.data);
		if(t.leftChild != null) {
			inorder(t.leftChild);
		}
		if(t.rightChild != null) {
			inorder(t.rightChild);
		}
	}
	
	public void postorder(TreeNode t) {		
		if(t.leftChild != null) {
			inorder(t.leftChild);
		}
		if(t.rightChild != null) {
			inorder(t.rightChild);
		}
		System.out.println(t.data);
	}
	
	public void printDFS() {
		System.out.println("In-order:");
		inorder(this.root);
		System.out.println("Pre-order:");
		preorder(this.root);
		System.out.println("Post-order:");
		postorder(this.root);
	}
}
