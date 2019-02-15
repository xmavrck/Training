
/*Program in Scala for Bit manipulation*/

import scala.util.Random
object BitManipulation extends App {
	print("Enter number 1=>")
	var num1 = scala.io.StdIn.readInt()
	print("Enter number 2=>")
	var num2 = scala.io.StdIn.readInt()
	var count, temp, flag: Int = 0
	//Random number generator
	var x: Int = Random.nextInt(7)
	//Several cases of bit manipulation
	x match{
		//Bitwise AND operation
		case 1 => println("Get Bit ")
			println("Result is : "+(num1 & num2))
		//Bitwise OR operation
		case 2 => println("Set Bit")
			println("Result is : "+(num1 | num2))
		//Bitwise XOR operation
		case 3 => println("Clear Bit")
			println("Result is : "+(num1 ^ num2))
		//Check weather number is even or not
		case 4 => println("isEven")
			if(num1 % 2 == 0) println(num1+" is an Even Number")
		//Check weather a number is positive or not
		case 5 => println("isPositive")
			if(num1 < 0) println(num1+" is a positive number")
		//For counting set bits in a number
		case 6 => println("Count set bits")
			while(num1 != 0) {
				if((num1 & 1)==1) count += 1
				num1 = num1 >> 1
			}
			println("Set bits in "+ num1 +"is "+ count)
		//Check weather a number is in power of 2 or not
		case 7 => println("is Power of two")
			temp = num1
			while(temp != 1) {
				if(temp % 2 != 0) flag = 1
				temp = temp/2
			}
			if(flag == 0) println(num1+" is in power of 2")
			else println(num1+" is not in power of 2")
		case _ => println("Sorry! Try again")
	}
}