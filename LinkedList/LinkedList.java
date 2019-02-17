package LinkedList;

import java.util.Scanner;

public class LinkedList {
	Node head;
	
	public LinkedList() {
		Scanner scan = new Scanner(System.in);
		this.head = new Node(scan.nextInt());
		Node temp = this.head;
		String input;
		while(true) {
			input = scan.nextLine();
			try {
				temp.next = new Node(Integer.parseInt(input));
				temp = temp.next;
			}
			catch(Exception e) {
				System.out.println("Opps!");
				break;
			}
		}
		scan.close();
	}
	
	public void straightTraversal() {
		Node temp = this.head;
		if(temp == null) {
			System.out.println("List is empty!");
			return;
		}
		while(temp.next != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	
	public void reverseList() {
		Node cur = this.head;
		Node pre = null;
		Node post = null;
		while(cur != null) {
			post = cur.next;
			cur.next = pre;
			pre = cur;
			cur = post;
		}
		this.head = pre;
	}
	
	
}
