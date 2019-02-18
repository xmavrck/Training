
/*Program in scala for finding the distance 
   between two strings or Haming Distance*/

object Main {
    //Function for finding the distance
    def HamingDistance(str1: String, str2: String): Int=
    {
        var i, count: Int = 0
        //finding the length
        while (i < str1.length()) 
        {
            if (str1.charAt(i) != str2.charAt(i))
                count = count + 1
            i = i + 1
        }
        //returning the distance
    return count
    }
    //Driver Code
	def main(args: Array[String]) {
	    //initializing the strings
		var str1: String = "Hello"
		var str2: String = "World"
		//Function calling
		println("Distance is: " +HamingDistance(str1, str2))
	}
}