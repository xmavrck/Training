let array=[2,-3,1,5,-4,6,-2,3];// Declaration of Array
let max=-32768;
let sum;
for(let i=0;i<array.length;i++)
  {
    sum=array[i];
    if(sum>max)
      max=sum;
    for(let j=i+1;j<array.length;j++)
      {
        sum+=array[j];
        if(sum>max)
          max=sum;
      }
  }
console.log(max);// Print maximum value of subarray

