function insertionSort(a,n)
{
  for(let i=0;i<n;i++)
    {
      for(let j=0;j<n-1;j++)
        {
          if(a[i]<a[j])
            {
              let temp=a[i];
              a[i]=a[j];
              a[j]=temp;
            }
        }
    }
  return a;
}
//test
let inputArray=[];
let size=prompt("enter size of array");
for(let x=0 ; x<size ; x++)
  {
     inputArray[x]=prompt("enter element");
  }

let result=[];
result=insertionSort(inputArray , size);
console.log(result);