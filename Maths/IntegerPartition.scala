
/*Program in Scala for Integer Partition*/

object Main {
	def main(args: Array[String])
	{
        val num = 8
        //Defining matrix size
        var mat = Array.ofDim[Int](num+1,num+1)
        //Fill the first row to 0
        for(i<-1 to num)
            mat(0)(i) = 0
        //Fill the first column to 1
        for(i<-0 to num)
            mat(i)(0) = 1
        //Finding the combinations of a number that it can be divided into
        for(x<-1 to num)
            for(y<-1 to num)
            {
                if(x > y)
                    mat(x)(y) = mat(x-1)(y)
                else
                {
                    val comboWithout = mat(x-1)(y)
                    val comboWith = mat(x)(y-x)
                    mat(x)(y) = comboWithout + comboWith
                }
            }
        //Displaying the ways
        println(num+" can be divided into "+mat(num)(num)+" ways")
	}
}