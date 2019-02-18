
/*Program in scala for Fibonacci series*/

object Main {
	def main(args: Array[String])
	{
	    val maxInput = 50
      var numberSer = 8
      if(numberSer > 50) numberSer = maxInput
      //setting the first two elements
      var current = 1
      var previous = 0
      
      //if inpt from user is one then print 0 only
      if(numberSer == 1) 
        println(0)
        //otherwise print upto user input
      else {
        println(previous + "\t" + current + "\t")
        var counter = 2
        //looping until user input
        while (counter < numberSer)
        {
            current = current + previous
            //calculating previous element by subtracting  it from current Element
            previous = current - previous
            
            counter = counter + 1
            
            //displaying the output
            println(current + "\t")
	    }
}
}
}