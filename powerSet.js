function powerSet(array) {
  var result = [];
  result.push([]);
  //sets in power set is pow(2,n) which we can get by (1<<array.length)
  for (var i = 1; i < (1 << array.length); i++) {
    var subset = [];
    
    for (var j = 0; j < array.length; j++)
     if (i & (1 << j))
        subset.push(array[j]);
     //push the sets in the subset array
      
    result.push(subset);
  }

  return result;
}
//test
let inputArray=[];
let size=prompt("enter size of array");
for(let i=0;i<size;i++)
  {
    inputArray[i]=prompt("enter sorted array");
    inputArray[i]=parseInt(inputArray[i]);
  }
console.log(powerSet(inputArray));