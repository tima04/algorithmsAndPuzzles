package scalaByExample

object Ch5 extends App {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def iter(a: Int, accum: Int): Int = {
      if (a > b) accum else iter(a + 1, f(a) + accum)
    }
    iter(a, 0)
  }


  // def sum_prod(op: (x: Int, y: Int, one: Int) => Int)(f: Int => Int)(a: Int, b: Int): Int = {
  def sum_prod(unt: Int)(op: (Int, Int) => Int)(f: Int => Int)(a: Int, b: Int): Int = {
    if (a > b) unt else op(f(a), sum_prod(unt)(op)(f)(a + 1, b))
    // def iter(a: Int, accum: Int): Int = {
    //   if (a > b) accum else iter(a + 1, op(f(a), accum))
    // }
    // iter(a, one)
  }

  def fact(n: Int) = sum_prod(1)((x, y) => x*y)(x => x)(1, n)

  //println(sum(x => x*x*x)(1, 2))
  println(sum_prod(1)((x, y) => x * y)(x => x*x*x)(1, 2))
  println(sum_prod(0)((x, y) => x + y)(x => x*x*x)(1, 2))
  println(fact(4))
}
