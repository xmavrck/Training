/*The problem is to count all the possible paths from top left to bottom right
we have matrxix of row X Column*/
function uniquePath(row,column)
{
  if(row==1 || column==1) //returning condition
    return 1;
  else
    //recursive call to function
    return uniquePath(row-1,column)+uniquePath(row,column-1) ;
}
let r=prompt("enter rows");
let col=prompt("enter column");
console.log("Number of unique path:  "+uniquePath(r,col));
