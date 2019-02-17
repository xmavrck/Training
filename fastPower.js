//this program will return power of given number

function fastPower(number,power)
{
  if(power==0)
       return 1;
  //recursively calling the function power times
  return number*fastPower(number,power-1)
}

//testing

let num=prompt("enter the number");
let pow=prompt("enter the power");
if(pow>=0 && num>0)
  {
  console.log("result is  "+fastPower(num,pow))
  }
else
  {
    alert("enter valid input");
  }
