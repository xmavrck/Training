function interpolationSearch(array,number,search) //Function of Interpolation Search
{
  let low=0;
  let high=number-1;
  while(low<=high && search>=array[low] && search<=array[high])
    {
      if(low==high)
        {
          if(array[low]==search)
            return low;
          return;
        }
      //main formula to calculate position
      let position=low+parseInt((parseFloat(high-low)/(array[high]-array[low]))*(search-array[low]));
      if(array[position]==search)
        return position;
      if(array[position]<search)
        low=position+1;
      else
        high=position-1;
    }
  return;
}
let number=prompt("Enter the size: ");// Size of Array
number=parseInt(number);
let array=[];
for(let i=0;i<number;i++)
  {
    array[i]=prompt(array[i]);// Taking input from user
    array[i]=parseInt(array[i]);
  }
let search=prompt("Enter the number to be searched: ");// Number to be searched
search=parseInt(search);
let searchposition=interpolationSearch(array,number,search); //Call Interpolation Search Function 
if(searchposition!=-1)
console.log(searchposition+1); //Print Search Position 