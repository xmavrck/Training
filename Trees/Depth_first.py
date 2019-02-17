import  re
#Node class that initializes the tree
class Node:
    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data
        return

#Function insert_element gets element from the user to build the tree.
#The function accepts an input sequence which is a list of numbers.
#The root_index is the location of ROOT NODE and its left child is at 2*root_index+1 and right child at 2*root_index+2

def insert_elements(input_sequence, root, root_index):
    length_of_sequence = len(input_sequence)
    if root_index < length_of_sequence:
        temp_root = Node(input_sequence[root_index])
        root = temp_root
        root.left = insert_elements(input_sequence, root.left, 2 *root_index + 1)
        root.right = insert_elements(input_sequence, root.right, 2 * root_index + 2)
    return root

#Inorder depth first traversal: Left -> root -> Right
def inorder(root):
    if root:
        inorder(root.left)
        print (root.data)
        inorder(root.right)

#Postorder depth first traversal: Left -> Right -> Root
def postorder(root):
    if root:
        postorder(root.left)
        postorder(root.right)
        print (root.data)

#Preorder depth first traversal: Root-> Left -> Right
def preorder(root):
    if root:
        print(root.data),
        preorder(root.left)
        preorder(root.right)

#Driver program
if __name__ == '__main__':
    input_sequence = re.split(r'[;,\s]\s*', input("enter the list of numbers"))
    root = None
    root = insert_elements(input_sequence, root, 0)
    print("\npreorder traversal\n")
    preorder(root)
    print("\ninorder traversal\n")
    inorder(root)
    print("\npostorder traversal\n")
    postorder(root)
