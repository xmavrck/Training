//following program will find substring p from a string s by using polynomial hashing (rolling hash) over Rabin-karp algorithm

object rabinKarp extends App{
  def matchRabinKarp(s: String, p: String): Int = {
    val n = s.length
    val m = p.length
    val q = 3355439
    val r = 256
    val d = (1 until m).foldLeft(1)((a, v) => (a * r) % q)

    def hash(ss: String, m: Int): Int =
      (0 until m).foldLeft(0)((a, v) => ((a * r) + ss.charAt(v)) % q)

    def loop(hs: Int, hp: Int, i: Int): Int =
      if (hs == hp) i - m
      else if (i == n) -1
      else {
        val hss = (hs - d * s.charAt(i - m) % q) % q
        loop((hss * r + s.charAt(i)) % q, hp, i + 1)
      }
    loop(hash(s, m), hash(p, m), m)
  }

  println("Index where string matches =>"+matchRabinKarp("lorem ipsum dolor sit amet", "sit"))
}