
/*Program in Scala for Unique Path*/

object Main {
	def main(args: Array[String])
	{
        val rows = 5
        val columns = 6
        //defining the size of board
        var board = Array.ofDim[Int](rows,columns)
        //first row and column to 1
        for(i<-0 until rows)
        {
            for(j<-0 until columns)
                if(i==0||j==0)
                    board(i)(j) = 1
        }
        //calculating next values and creating the path
        for(i<-1 until rows) for(j<-1 until columns)
        {
            val uniqFromTop = board(i - 1)(j)
            val uniqFromLeft = board(i)(j - 1)
            board(i)(j) = uniqFromTop + uniqFromLeft
        }
        println("Total Number of Unique paths from start to end is: "+board(rows-1)(columns-1))
	}
}