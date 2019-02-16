function fib(n) {
  if (n <= 1) {
    return n;
  } else {
    //recursive call to fabinacci function
    return fib(n - 1) + fib(n - 2);
  }
}
//test

//setting the max number
let maxno=40;
let num=prompt("enter number");
if(num>40) //if number goes out of range set it to max
  num=maxno;
console.log(fib(num)); // re