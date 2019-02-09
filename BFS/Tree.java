package BFS;
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
	
	public Tree() {
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> treeData = new ArrayList<Integer>();
		String input = scan.nextLine();
		String[] inputSplit = input.split(",");
		for(int i = 0; i<inputSplit.length; i++) {
			treeData.add(Integer.parseInt(inputSplit[i]));
		}
//		set tree from ArrayList
		this.setTreeByBFS(treeData);
		scan.close();
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
}
