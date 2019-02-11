function print(array) // Print Array
{
  for(let i=0;i<array.length;i++)
    console.log(array[i]);
}
function insertionsort(array) // Function of Insertion Sort
{
  let i,j,temp;
  for(i=1;i<array.length;i++)
    {
      temp=array[i];
      j=i-1;
      while(array[j]>temp && j>=0)
        {
          array[j+1]=array[j];
          j--;
        }
      array[j+1]=temp;
    }
}
array=[6,4,3,7,2,9,8,1,5];// Declaration of Array
insertionsort(array);// Calling Insertion Sort Function
print(array);// Calling Print Function
