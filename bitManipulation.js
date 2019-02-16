function bitManipulation(a,b)
{
  let element=Math.floor(Math.random() * 8);
  switch(element)
    {
      case 1:
        console.log("bitwise AND")
        console.log(a & b);
        break;
      case 2:
        console.log("bitwise OR");
        console.log(a | b);
        break;
      case 3:
        console.log("bitwise XOR")
        console.log(a ^ b);
        break;
      case 4:
        console.log("bitwise Left Shift a by 1");
        console.log(a << 1);
        break;
      case 5:
        console.log("bitwise Right Shift b by 1");
        console.log(a >> 1)
        break;
      case 6:
        console.log("No is positive or not?")
        if((a%2)== 0)
          {console.log("a is positive");}
        else
          {console.log("a is not positive")}
        if((b%2)==0)
          {console.log("b is positive");}
        else
          {console.log("b is not positive");}
        break;
      case 7:
        console.log("counting number of ON bits in a");
        let count=0;
        while(a>0)
          {
            if((a & 1) ==1)
              count+=1;
            a=a>>1;
          }
        console.log(count);
        break;
      case 8:
        console.log("bitwise NOT");
        num1=~a;
        num2=~b;
        console.log("NOT of a= "+a);
        console.log("NOT of b=  "+b);
        break;
        
    }
}
let num1=prompt("enter a");
let num2=prompt("enter b")
bitManipulation(num1,num2)
