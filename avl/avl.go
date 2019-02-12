package main

import (
	"fmt"
)

type avl struct {
	Key    int
	height int
	LC, RC *avl
}

type action func(node *avl)

func leftrotate(root *avl) *avl {
	node := root.RC
	root.RC = node.LC
	node.LC = root

	root.height = max(height(root.LC), height(root.RC)) + 1
	node.height = max(height(node.RC), height(node.LC)) + 1
	return node
}

func leftrigthrotate(root *avl) *avl {
	root.LC = leftrotate(root.LC)
	root = rigthrotate(root)
	return root
}

func rigthrotate(root *avl) *avl {
	node := root.LC
	root.LC = node.RC
	node.RC = root
	root.height = max(height(root.LC), height(root.RC)) + 1
	node.height = max(height(node.LC), height(node.RC)) + 1
	return node
}

func rightleftrotate(root *avl) *avl {
	root.RC = rigthrotate(root.RC)
	root = leftrotate(root)
	return root
}

func height(root *avl) int {
	if root != nil {
		return root.height
	}
	return -1
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func addNode(root *avl, key int) *avl {
	if root == nil {
		root = &avl{key, 0, nil, nil}
		root.height = max(height(root.LC), height(root.RC)) + 1
		return root
	}

	if key < root.Key {
		root.LC = addNode(root.LC, key)
		if height(root.LC)-height(root.RC) == 2 {
			if key < root.LC.Key {
				root = rigthrotate(root)
			} else {
				root = leftrigthrotate(root)
			}
		}
	}

	if key > root.Key {
		root.RC = addNode(root.RC, key)
		if height(root.RC)-height(root.LC) == 2 {
			if key > root.RC.Key {
				root = leftrotate(root)
			} else {
				root = rightleftrotate(root)
			}
		}
	}

	root.height = max(height(root.LC), height(root.RC)) + 1
	return root
}

func inOrder(root *avl, action action) {
	if root == nil {
		return
	}

	inOrder(root.LC, action)
	action(root)
	inOrder(root.RC, action)
}

func main() {
	var root *avl
	var n int
	fmt.Printf("Enter the size of the array: ")
	fmt.Scanf("%d", &n)
	array := make([]int, n)
	fmt.Printf("Enter the element in the array:\n")
	for i := 0; i < n; i++ {
		fmt.Scanf("%d ", &array[i])
	}

	for count := range array {
		root = addNode(root, array[count])
	}
	inOrder(root, func(node *avl) {
		fmt.Print("Value: ", node.Key, " Height: ", node.height, "\n")
	})
}
