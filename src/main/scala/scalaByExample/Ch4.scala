package scalaByExample 

object Ch4 extends App {
  def sqrt(x: Double): Double = {
    def sqrtIter(guess: Double): Double = {
      if (isGoodEnough(guess)) guess else sqrtIter(improve(guess))
    }
    def improve(guess: Double) = (guess + x/guess)/2
    def isGoodEnough(guess: Double) = abs(guess - x/guess) < 1e-4
    def abs(x: Double) = if(x > 0) x else -x
    sqrtIter(1.0)
  }

  def factorial(n: Int): Int = {
    def factorialIter(n: Int, accum: Int): Int = {
      if (n == 1) accum else factorialIter(n-1, n*accum)
    }
    factorialIter(n, 1)
  }
  
  println("fact is: " + factorial(3))
}
