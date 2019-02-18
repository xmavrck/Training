/*

@author akash

@readCase "print and println are used to customize the output screen"

*/

//following program will implement tower of hanoi problem
object hanoi extends App {

  //method is recursive and performing movement of disks from one node to other via aux rod
  def towerOfHanoi(disksCount: Int, from_rod: Char, to_rod: Char, aux_rod: Char): Unit ={
    //if disk count is one then show movement
    if(disksCount == 1) println("1('"+from_rod+"'=>'"+to_rod+"')")
    else {
      //recursive calling and printing and then backtrack recursive calling
      towerOfHanoi(disksCount-1, from_rod, aux_rod, to_rod)
      println(disksCount + "('" +  from_rod + "'=>'" + to_rod+"')")
      towerOfHanoi(disksCount-1, aux_rod, to_rod, from_rod)
    }
  }

  //user input for disks count
  print("Enter number of Disks:")
  val disks = scala.io.StdIn.readInt()

  //calling main runner method
  towerOfHanoi(disks, 'A', 'C', 'B')
}

//Output is like
//DiskNumber('From Rod'=>'To Rod')
//            ....
//            ....
//            ....
//            ....
//DiskNumber('From Rod'=>'To Rod')