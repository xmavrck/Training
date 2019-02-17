// we have n steps and can hop either 1 step, 2 steps, or 3 steps at a time
function countWays(n)
{
  let x=[];
	//set the first three positions
  x[0]=1;
  x[1]=1;
  x[2]=2;
	//now add previous three position
  for(let i=3;i<= n;i++)
         x[i]=x[i-1]+x[i-2]+x[i-3];
    
  return x[n];
  
}
//result
let max=80;
let num=prompt("enter number below 80");
if(num>80)
  {
    num=max;
  }
console.log("result is:"+countWays(num));
