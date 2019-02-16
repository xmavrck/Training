function linearSearch(a,item)
{
  size=a.length;
  for(let i=0;i<size;i++)
    {
      if(a[i]==item)
        {
          return i;
        }
      
    }
  alert("item not found");
  
}
//test
let inputArray=[];
let size=prompt("enter size of array");
for(let x=0 ; x<size ; x++)
  {
     inputArray[x]=prompt("enter element");
  }
let item=prompt("enter item to be searched");

let result;
result=linearSearch(inputArray , item);
console.log(result-1);