package main

import (
	"fmt"
)

type node struct {
	num  int
	next *node
}

type traversal struct {
	head *node
}

func AddNewNode(num int) *node {
	return &node{num, nil}
}
func (ll *traversal) Front(num int) {
	n := AddNewNode(num)
	n.next = ll.head
	ll.head = n
}

func (ll *traversal) End(num int) {
	n := AddNewNode(num)

	if ll.head == nil {
		ll.head = n
		return
	}

	cur := ll.head
	for ; cur.next != nil; cur = cur.next {
	}
	cur.next = n
}

func (ll *traversal) disp() {
	for cur := ll.head; cur != nil; cur = cur.next {
		fmt.Print(cur.num, " ")
	}

	fmt.Print("\n")
}
func main() {
	ll := traversal{}
	var n, val int
	for {
		fmt.Scanf("%d ", &n)
				if n == 4 {
			break
		}
		switch n {
		case 1:
			fmt.Printf("Enter value to be inserted at beginning\n")
			fmt.Scanf("%d ", &val)
			ll.Front(val)
			break
		case 2:
			fmt.Printf("Enter value to be inserted at the end\n")
			fmt.Scanf("%d ", &val)
			ll.End(val)
			break
		case 3:
			fmt.Printf("Element in the list are: ")
			ll.disp()
			break

		default:
			fmt.Printf("Wrong input\n")
		}

	}
	fmt.Printf("Thank you\n")
}
