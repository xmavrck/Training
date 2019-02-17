/*it is based on kadane's algorithm*/

/*This algorithm will not consider negative in the arraylist*/
function subArray(a)
{
  console.log(a)
  let size=a.length;
  let maxPre=0; //keep tracking the previous values
  let maxNow=0; //keep tracking the current value
  for(let i=0;i<size;i++)
    {
      maxNow=maxNow + a[i];
     if(maxPre < maxNow) //if prev value is lower then update it
        maxPre=maxNow;
      if(maxNow<0)  //if current value is negative then set it to 0
        maxNow=0;
     }
  
  return maxPre;
}

let number=prompt("Enter the size: ");// Size of Array
number=parseInt(number);
let array=[];
for(let i=0;i<number;i++)
  {
    array[i]=prompt("Enter the number: ");// Taking input from user
    array[i]=parseInt(array[i]);
  }
console.log("Result is " +subArray(array));