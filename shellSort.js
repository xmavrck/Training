function shellSort(array)
{
  let size=array.length,temp,j;
  //we will first reduce the array to half and assign it to the gap
  for(let gap=Math.floor(size/2) ; gap>0; gap=Math.floor(gap/2))
    {
      //then we will reduce the gap to one
      for(let i=gap; i<size;i+=1)
        {
          //a[i] the element after the gap will be store in temp
          //then we will compare it.
          temp=array[i];
          //shift the arrays by comparing it and until correct            location is not found
          for(j=i; j >= gap && arr[j-gap] > temp ; j-=gap)
                      array[j]=array[j-gap];
          array[j]=temp; 
       // console.log(j)      
        }
      
    }
  return 0;
}
//test 
let size=prompt("enter size");
let arr=[];
for(let i=0;i<size;i++)
  {
   arr[i]=prompt("Enter array");
  }
shellSort(arr);
console.log(arr);