/*this program will perform preOrder(Root-Left-Right) Traversal*/
class Node
  {
    constructor(data)
    {this.data=data;
     this.left=null;
      this.right=null;
    }
  }

class binaryTree
  {  
    constructor()
    {
      this.root=null;
    }
    printInorder(node)
    {
      
      if(node==null)
        return;
       console.log(node.data);
      //call the letf subtree
      this.printInorder(node.left);
      
     
      //call right subtree 
      this.printInorder(node.right);
     
    }
    pritInorder()
    { printInorder(root); }
    
  }
//test
let tree=new binaryTree();
tree.root=new Node(10);
tree.root.left=new Node(20);
tree.root.right=new Node(30);
tree.root.left.left = new Node(40); 
tree.root.left.right = new Node(50); 

tree.printInorder(tree.root)