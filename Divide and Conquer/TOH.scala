
/*Tower Of Henoi Problem*/

object Main {
    //function for the problem
    def ToH(n: Int, p: Char, q: Char, r: Char)
    {
        if(n == 1)
        {
            println("Move disk 1 from rod "+p+"to rod "+q)
        }
        ToH(n-1, p, r, q)
        println("Move disk "+n+ " from rod"+p+" to rod "+q)
        ToH(n-1, r, q, p)
    }
    //driver code
	def main(args: Array[String])
	{
		var n: Int = 4
		ToH(n, 'A', 'C', 'B')
	}
}