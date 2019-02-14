function binarySearch(a,beg,end,item)
{
  mid=Math.floor((beg+end)/2);
  
  if(a[mid] == item)
  {  
    return mid;
  }
  else if(a[mid] > item)
  { //item in the first half
    return binarySearch(a,beg,mid-1,item);
  } 
  else
  {
    
    return binarySearch(a,mid+1,end,item);
  }
  return -1;
}
//test
let inputArray=[];
let size=prmpt("enter size of array");
for(let i=0;i<size;i++)
  {
    inputArray[i]=prompt("enter sorted array"+(i+1));
  }
let item=prompt("enter item to be searched");
let result=binarySearch(inputArray,0,size-1,item);
console.log("item is at position");
console.log(result+1);
