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
func (ll *traversal) reverse() {
	var prev, next *node
	cur := ll.head

	for cur != nil {
		next = cur.next
		cur.next = prev
		prev = cur
		cur = next
	}

	ll.head = prev
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
		fmt.Printf("\n---------------------------INPUT--------------------------------------")
		fmt.Printf("\nPress\n1. To add at beginning\n2.To add at end\n3.To disp\n4.For Exit.\n")
		fmt.Scanf("%d", &n)
		fmt.Printf("---------------------------xxx--------------------------------------\n")
		if n == 4 {
			break
		}
		switch n {
		case 1:
			fmt.Printf("Enter value to be inserted at beginning\n")
			fmt.Scanf("%d", &val)
			fmt.Printf("---------------------------xxx--------------------------------------\n")

			ll.Front(val)
			break
		case 2:
			fmt.Printf("Enter value to be inserted at the end\n")
			fmt.Scanf("%d", &val)
			ll.End(val)
			break
		case 3:
			fmt.Printf("---------------------------OUTPUT--------------------------------------\n")
			fmt.Printf("Element in the list are: ")
			ll.disp()
			fmt.Printf("\nElement in reverse order are: ")
			ll.reverse()
			ll.disp()
			fmt.Printf("---------------------------xxx--------------------------------------")
			break

		default:
			fmt.Printf("Wrong input\n")
		}

	}
	fmt.Printf("Thank you\n")
}
