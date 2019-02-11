
/*Program in Scala for Bit manipulation*/

import scala.util.Random
object Main {
    
	def main(args: Array[String]) {
	    //Initialization of variables
	    var num1: Int = 5
	    var num2: Int = 7
	    var result: Int = 0
	    var count: Int = 0
	    var temp: Int = 0
	    var flag: Int = 0
	    
	    //Random number generator
	    val x: Int = Random.nextInt(10)
	    
	    //Several cases of bit manipulation
	    x match{
	        //Bitwise AND operation
	        case 1 => println("Get Bit ")
	                  result = num1 & num2
	                  println("Result is : "+result)
	                  
	       //Bitwise OR operation
	        case 2 => println("Set Bit")
	                  result = num1 | num2
	                  println("Result is : "+result)
	                  
	       //Bitwise XOR operation
	        case 3 => println("Clear Bit")
	                  result = num1 ^ num2
	                  println("Result is : "+result)
	                  
	       //Check weather number is even or not
	        case 4 => println("isEven")
	                  if(num1 % 2 == 0)
	                  println(num1+" is an Even Number")
	                  
	       //Check weather a number is positive or not
	        case 5 => println("isPositive")
	                  if(num1 < 0)
	                  println(num1+" is a positive number")
	                  
	       //For counting set bits in a number
	        case 6 => println("Count set bits")
	                  while(num1 != 0)
	                  {
	                      if((num1 & 1)==1)
	                      count += 1
	                      num1 = num1 >> 1
	                  }
	                  println("Set bits in "+ num1 +"is "+ count)
	                  
	       //Check weather a number is in power of 2 or not
	        case 7 => println("is Power of two")
	                  temp = num1
	                  flag = 0
	                  while(temp != 1)
	                  {
	                      if(temp % 2 != 0)
	                      {
	                          flag = 1
	                      }
	                      temp = temp/2
	                  }
	                  if(flag == 0)
	                  println(num1+" is in power of 2")
	                  else
	                  println(num1+" is not in power of 2")
	    }
	}
}