class Node
  {
    constructor(data)
    {
      this.data=data;
      this.next=null;
    }
  }
class LinkedList
  {
    constructor()
    {
      this.head=null;
    }
    straightTraverse()
    {
      //staright traversal
      let temp=this.head
      while(temp!=null)
        {
          console.log(temp.data)
          temp=temp.next;
        }
    }
    pushData(data)
      {
        if(this.head == null)
          this.head=new Node(data);
        else
          {
            let temp=this.head;
            while(temp.next!=null)
              temp=temp.next;
            temp.next=new Node(data);
          }
      }
  }
let data1=new LinkedList();
let size=prompt("enter the size:");
for(let i=0;i<size;i++)
  {
    number=prompt("Enter the data");
    number=parseInt(number);
    data1.pushData(number);
  }
console.log("list is");
data1.straightTraverse();