
/*Knapsack Problem in Scala*/

object Main {
    
    //Function for finding maximun value
    def max(x: Int, y: Int): Int={
        if(x>y)
            return x
        else
            return y
    }
    //Function for The main problem
    def KnapSack(w: Int, wt: Array[Int], valu: Array[Int], n: Int): Int={
        if(n==0 || w == 0)
            return 0
        if(wt(n-1) > w)
            return KnapSack(w, wt, valu, n-1)
        else
            return max(valu(n-1) + KnapSack(w-wt(n-1), wt, valu, n-1), KnapSack(w, wt, valu, n-1))
    }
    //Driver Code
	def main(args: Array[String]) {
		var valu = Array(60, 100, 120)
		var wt = Array(10, 20, 30)
		var w = 50
		//Calculating the length
		var n: Int = valu.length
		//displaying the output and function calling
		println(KnapSack(w, wt, valu, n))
	}
}