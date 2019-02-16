let partition=function()
{
  //this is for is
  this.printarray=function (a,number) //Function of Printing Array
  {
    for(let i=0;i<number;i++)
      a.join(''); 
    console.log(a);
  }
  this.integerpartition=function(number) //Function of Integer Partition
  {
    let a=[]; 
    let last=0;
    a[last]=number;
    while(true)
    {
      this.printarray(a,last+1);
      let left=0;
      while(last>=0 && a[last]==1)
      {
        left+=a[last];
        last--;
      }
      if(last<0)
        return;
      a[last]--;
      left++;
      while(left>a[last])
      {
        a[last+1]=a[last];
        left=left-a[last];
        last++;
      }
      a[last+1]=left;
      last++;
    }
  }
}
let x=new partition();
let number=prompt("Enter the number below 30: ");// Enter the number
number=parseInt(number);
x.integerpartition(number); //Call Integer Partition Function--