
/*Program for Rabin karp Algorithm in scala*/
//import scala.math.PI
import util.control.Breaks._
object Main {
    //Function for Rabin Karp
    def RabinKarp(pattern : Array[String], text : Array[String], q: Int)
    {
        //Finding the length of text and pattern to be found
        var m: Int = pattern.length
        var n: Int = text.length
        //Initialization of variables
        var patt: Int = 0
        var txt: Int = 0
        var h: Int = 1
        var d: Int = 256
        var j: Int = 0
        
        for(i <- 0 until m-1)
            h = (h*d) % q
        for(i <- 0 until m)
        {
            patt = (d*patt + pattern(i)) % q
            txt = (d*txt + text(i)) % q
        }
        //Using break statement
             for(i <- 0 to n-m)
            {
                //if pattern and text found
                if(patt == txt)
                {
                    breakable
                    {
                        for(j <- 0 until m)
                        {
                            if (text(i+j) != pattern(j))
                            break()
                        }
                    }
                        //displaying the output
                        if(j == m)
                            println("Pattern is found at the index: "+i)
                 if ( i < n-m) 
                { 
                    txt = (d*(txt - text(i)*h) + text(i+m))%q
                    if (txt < 0)
                        txt = (txt + q) 
                } 
            }
        }
    }
    
    //Driver code
	def main(args: Array[String])
	{
	    //Providing the text and pattern as input
	    var text = Array("HELLO WORLD")
	    var pattern = Array("HELL")
	    var q: Int = 101
	    //Functiion calling
	    RabinKarp(pattern, text, q)
	}
}