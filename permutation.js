//this program will find the permutations*/
 var permArr = [],array = [];
function permutation(input) {
 
  var i, ch;
  for (i = 0; i < input.length; i++) {
    ch = input.splice(i, 1)[0];//splice will fetch the element one by one
    array.push(ch);
    if (input.length == 0) {
      permArr.push(array.slice());
    }
    permutation(input); //calling function again
    input.splice(i, 0, ch);
    array.pop();
  }
  return permArr
};

//test
let set=[];
var size=prompt("Enter the size: ");// Enter the size
for(var i=0;i<size;i++)
  {
    set[i]=prompt("Enter the number: ");// Taking input from user
    set[i]=parseInt(set[i]);
    
  }
console.log((permutation(set)))