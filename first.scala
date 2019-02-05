//calculating multiplicative inverse
class first {
  def modInverse(x: Int, y: Int): Int ={
    var g = gcd(x,y)
    if(g!=1) 0 else power(x,y-2,y)
  }
  def gcd(i: Int, i1: Int): Int = if (i == 0) i1 else gcd(i1%i, i)
  def power(i: Int, i1: Int, i2: Int): Int ={
    if(i1 == 0) return 1
    var p: Int = power(i, i1/2, i2) % i2
    p = (p * p) % i2
    if (i1%2 == 0) p else ( i * p ) % i2
  }
}

//polynomial hash
class poly_hash(var ibase: Int, var base: Int, var prime: Int, var dataToBeHashed: String, var hashh: Int = 0, var magic: Int = 1, var oldPos: Int = 0){
  def hash(): Int ={
    var j: Int = 0
    while(j < dataToBeHashed.length){
      //uncomment following if when hash for particular window size is to be calculated
      //replace window size with integer value of known window size
      //if(j < WindowSize) append(dataToBeHashed.charAt(j)) else{
        //skip(dataToBeHashed.charAt(oldPos))
        append(dataToBeHashed.charAt(j))
        //oldPos += 1
      //}
      j+=1
    }
    hashh
  }
  // when hash of particular window size is needed and it will remove a character from front and create a space at end for append method
  def skip(old: Int): Unit ={
    hashh = ((hashh-old*magic) + prime*base) % prime
    magic = (magic*ibase) % prime
  }
  // will append a new hash of a new character from a string to end for polynomial hash
  def append(neww: Int): Unit ={
    hashh += (hashh * base + neww) % prime
    magic = (magic * base) % prime
  }

}

//runner object
object fi{
  def main(args: Array[String]): Unit = {
    var start=System.currentTimeMillis()
    val base: Int = 64 // base to the word size (can be taken from 32,64,256 based on bit size
    val prime_number: Int = 23 // to make calculations more linear, any prime number can be chosen
    val dataToBeHashed: String = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"
    val first = new first()
    // will find multiplicative inverse of base with modulo of prime number
    val ibase: Int = first.modInverse(base, prime_number) //base, prime number for modulo
    if(ibase == 0) println("No multiplication Inverse found")
    else{
      val has = new poly_hash(ibase, base, prime_number, dataToBeHashed)
      println(has.hash())
    }
    println(System.currentTimeMillis()-start)
  }
}
