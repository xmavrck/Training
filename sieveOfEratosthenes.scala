/*

@author akash on 15/2/19 2:28 PM

*/

//following function will find all first n prime numbers, where n will be the user input
object sieveOfEratosthenes extends App{
  //this will check if tail element of stream when mod to head of stream produces 0 or not
  // if not then only added to stream of integers
  def sieve(s: Stream[Int]): Stream[Int] = s.head #:: sieve(s.tail filter(_ % s.head != 0))

  //starting from
  val primes = sieve(Stream.from(2))

  //getting user input
  println("How many prime numbers? ")
  val count = scala.io.StdIn.readInt()

  //printing all primes
  (primes take count) foreach { println(_) }

}
