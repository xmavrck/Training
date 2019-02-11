function printarray(a,number) //Function of Printing Array
{
  for(let i=0;i<number;i++)
      a.join(''); 
  console.log(a);
}
function integerpartition(number) //Function of Integer Partition
{
  let a=[]; 
  let last=0;
  a[last]=number;
  while(true)
    {
      printarray(a,last+1);
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
integerpartition(5); //Call Integer Partition Function



