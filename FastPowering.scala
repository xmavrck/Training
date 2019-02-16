
/*Progarm for fast powering in Scala*/

object Main {
    //Function for calculating fast powering
    def FastPower(x: Int, y: Int): Int=
    {
        //for o power return 1
        if (y == 0)
            return 1
        else if (y % 2 == 0)
            return FastPower(x, y / 2) * FastPower(x, y / 2)
        else
            return x * FastPower(x, y / 2) * FastPower(x, y / 2)
    }
    //driver code
	def main(args: Array[String])
	{
		var x: Int = 4
		var y: Int = 5
		//displaying and calling the function
		println(FastPower(x,y))
	}
}