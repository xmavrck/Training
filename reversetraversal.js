class Node
  {
    constructor(data)
    {
      this.data=data;
      this.next=null;
    }
  }
class LinkedList// Class of LinkedList
  {
    constructor()
    {
      this.head=null;
    } 
    reverse()// Function of Reverse of LinkedList
    {
      var current=this.head;
      var prev=null;
      var next=null;
      while(current!=null)
        {
          next=current.next;
          current.next=prev;
          prev=current;
          current=next;
        }
      this.head=prev;
    }
    print()// Function of Print of LinkedList
    {
      var temp = this.head;
      while(temp!=null)
        {
          console.log(temp.data);
          temp=temp.next;
        }
    }
    push(data)// Function to push the element
    {
      if(this.head == null)
        this.head = new Node(data);
      else
      {
        var temp=this.head;
        while(temp.next != null)
          temp = temp.next;
        temp.next = new Node(data);
      }
    }
}
var l = new LinkedList();// Create object of LinkedList 
var size=prompt("Enter the size: ");// Enter the size
for(var i=0;i<size;i++)
  {
    number=prompt("Enter the number: ");// Taking input from user
    number=parseInt(number);
    l.push(number);
  }
console.log("Linked List: ");
l.print();// Calling Print Function before reverse
l.reverse();// Calling Reverse Function
console.log("Reverse Linked List: ");
l.print();// Calling Print Function after reverse

