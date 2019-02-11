function fisherYates(a,currIndex)
{
  
  let randomIndex,temp;
  //prforming swaping in array
  for(let i=(currIndex-1);i>0;i--)
  {
      randomIndex=Math.floor(Math.random() * i);
      temp=a[currIndex];
      a[currIndex]=a[randomIndex];
      a[randomIndex]=temp;
    }
  return a;
}

//test
var inputArray = [];
var size; //Maximum Array size
size=prompt("enter size ");
for(var i=0; i<size; i++) {
	
	//Taking Input from user
	inputArray[i] = prompt('Enter Element ' + (i+1));
}
let result=fisherYates(inputArray,size-1);
console.log(result);
