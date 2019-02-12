function print(array,number)// Print Array
{
  console.log(array);
}  
function insertionsort(array,number) // Function of Insertion Sort
{
  let i,j,temp;
  for(i=1;i<number;i++)
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
let number=prompt("Enter size: ");// Size of Array
number=parseInt(number);
let array=[];
for(let i=0;i<number;i++)
  {
    array[i]=prompt("Enter the number: ");// Taking input from user
    array[i]=parseInt(array[i]);
  }   
insertionsort(array,number);// Calling Insertion Sort Function
print(array,number);// Calling Print Function

