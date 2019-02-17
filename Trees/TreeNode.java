package Trees;

public class TreeNode {
	int data;
	public TreeNode leftChild;
	public TreeNode rightChild;
	public TreeNode parent;
	
	public TreeNode(TreeNode par) {
		this.data = -100;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = par;
	}
	
	public TreeNode(int dt) {
		this.data = dt;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}
	
	public TreeNode(int dt, TreeNode par) {
		this.data = dt;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = par;
	}
}
