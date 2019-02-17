/*rotate a matrix 90 degree*/
function rotateMatrix(arr)
{
  let newArr=[];
  let rowSize= Math.floor(Math.sqrt(arr.length));
    
  for(let i=0;i< arr.length;i++)
    {
      
      let x=i%rowSize;
      let y=Math.floor(i/rowSize);
      //convert x and y
      let newX=rowSize - y - 1;
      let newY=x;
      //get the new positions
      let newPosition=Math.floor(newY*rowSize+newX);
       
      newArr[newPosition]=arr[i];
      
    }  return newArr;
  
}

var grid = [
 
  [0,0], [0,1], [0,2], [0,3],
  [1,0], [1,1], [1,2], [1,3],
  [2,0], [2,1], [2,2], [2,3],
  [3,0], [3,1], [3,2], [3,3]]; 
var result=rotateMatrix(grid);
console.log(result);
/*
result will be:
[3,0], [2,0], [1,0], [0,0], 
  [3,1], [2,1], [1,1], [0,1], 
  [3,2], [2,2], [1,2], [0,2], 
  [3,3], [2,3], [1,3], [0,3] */