
/*Program in Scala for Sieve of Eratosthens*/

import scala.util.control.Breaks
object Algo1Sieve {
 def main(args: Array[String]){
     //initilaizing the variables
 var i: Int =5
 var j = Long
 var f: Int=1
 var c: Int = 2
 var n = 100
 var l = new Breaks;
 var prime= new Array[Int](n)
 prime(0)= 2
 prime(1)= 3
 while(i<=n){
   f=1
  for(j<-0 until n if j<c && prime(j) * prime(j) <= i ){
   l.breakable{
    if(i%prime(j)==0){
     f=0;
     l.break()
    }
   }
  }
   if(f>0){
    prime(c)=i
    c+=1
   }

  i+=1
 }
 //displaying the output
 print("total prime numbers are: " +c+"\n \n"+"Prime numbers are: "+"\n")
 for(i<-0 until c){
  print(prime(i)+"\n")
 }
}
}