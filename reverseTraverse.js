/*reverse the node by traversing from last to first*/
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
    reverseList()
    {
      var current=this.head;  //set the head to current
      
      var prev=null;
      var next=null;
      while(current!=null)
        {
          //traverse until current is null
          next=current.next;  
          current.next=prev;  
          prev=current; 
          current=next; 
        }
      this.head=prev;
    }
    printList()
    {
      //this function will print the list 
      //first we assight head pointer to temp and traverse to end until it reach last node
      var temp = this.head;
      while(temp!=null) 
        {
          console.log(temp.data);
          temp=temp.next; //traverse until end
        }
    }
    pushList(data)
    {
      //this function will add data to the linked list
      //first we check wheather head is having element or not
      //if not we add a node
      if(this.head == null)
        this.head = new Node(data);
      else
      {
        //this block will run when we have some liked list 
        //we will traverse to end and add at the end of the list
        var temp=this.head;
        while(temp.next != null)
          temp = temp.next;
        temp.next = new Node(data);
      }
    }
}
var l = new LinkedList();// Create object of LinkedList 
var size=promp("Enter the size: ");// Enter the size
for(var i=0;i<size;i++)
  {
    number=prompt("Enter the number: ");// Taking input from user
    number=parseInt(number);
    l.pushList(number);
  }
console.log("Linked List: ");
l.printList();// Calling Print Function before reverse
l.reverseList();// Calling Reverse Function
console.log("Reverse Linked List: ");
l.printList();// Calling Print Function after reverse