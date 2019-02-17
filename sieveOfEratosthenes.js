//this program will find prime number between 2 to given number num using sieve of Eratosthnes algorithm
function sieve(n)
{
  //initialize the array to true first and then we will make it false if it is not prime
  var array=new Array(n).fill(true);
  
  for(let p=2;p*p<n;p++)
    {
     
          //make the array element false where it has multiple
          for(let j=p*p;j<=n;j+=p)
            {
              array[j]=false;
            }
           
      }
  return array;
  
}

//tets cases

let x=[];
let num=prompt("enter number");
x = sieve(Math.floor(num));
for(let i=0;i<num;i++)
  {
    if(x[i]==true)
      {
        console.log(i);
      }
  }
