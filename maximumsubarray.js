let number=prompt("Enter the size: ");// Size of Array
number=parseInt(number);
let array=[];
for(let i=0;i<number;i++)
  {
    array[i]=prompt("Enter the number: ");// Taking input from user
    array[i]=parseInt(array[i]);
  }
let max=-32768;
let sum;
for(let i=0;i<number;i++)
  {
    sum=array[i];
    if(sum>max)
      max=sum;
    for(let j=i+1;j<number;j++)
      {
        sum+=array[j];
        if(sum>max)
          max=sum;
      }
  }
console.log(max);// Print maximum value of subarray
