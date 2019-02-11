//check for min element
function checkMin(a,b)
  {
    let c=a>b?a:b;
    return c;
  }
function search(ar,item)
{
  prev=0;
  let n=ar.length;
  let step=Math.floor(Math.sqrt(n));
  console.log(step);
  while(ar[checkMin(step,n)-1]<item)
  {
    prev=step;
    step+=Math.floor(Math.sqrt(n));
    if(prev>=n) //element not found
      {
        return;
      }
  }
  
  while(a[prev] < item)
    {
      prev++;
      if(a[prev]==item)
        {
          return prev;
        }
      if(prev == checkMin(step,n))
        {
          return;
        }
    }
}


// test cases
var inputArray = [];
var size; //Maximum Array size
size=prompt("enter size ");
for(var i=0; i<size; i++) {
	
	//Taking Input from user
	inputArray[i] = prompt('Enter Element ' + (i+1));
}
console.log(inputArray);
let item=prompt('Enter item ');
//Print the array in the console.
let result=search(inputArray,item);
if(!result)
  {
    console.log("out of range");
  }
else
  {
    
console.log(result);
    
  }