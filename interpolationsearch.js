function interpolation(array,number,search) //Function of Interpolation Search
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
let array=[2,4,6,7,8,10];// Declaration of Array
let number=array.length;
let search=8;
let searchposition=interpolation(array,number,search); //Call Interpolation Search Function 
if(searchposition!=-1)
  console.log(searchposition); //Print Search Position 



