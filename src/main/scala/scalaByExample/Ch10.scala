package scalaByExample 
import math._
import java.io.PrintWriter

object Ch10 extends App {
/*

  case class Cell(i: Int, j: Int) extends Ordered[Cell] {

    def compare(that: Cell): Int =
      if (this.i > that.i)
        return true
    if(this.i == that.i & this.j >= that.j)
        return true
    false
  }

  type Cells = List[Cell]

  def pprintfile(k: Int, cells: Cells, fl: PrintWriter) {
    for (i <- 1 to k) {
      fl.println()
      for(j <- 1 to k) {
        var x = if(cells.exists(x => x == Cell(i, j))) "*" else "O"
        fl.print(x + "  ")
        }
    }
    fl.println()
    fl.println()
  }

  def pprint(k: Int, cells: Cells) {
    for (i <- 1 to k) {
      println()
      for(j <- 1 to k) {
        var x = if(cells.exists(x => x == Cell(i, j))) "*" else "O"
        print(x + "  ")
        }
    }
    println()
    println()
  }

  val n = 8 
  val k = 8 

  val fl = new PrintWriter("temp.txt")
  nQueen(n, k).foreach(x => pprintfile(k, x, fl))
  fl.close()

  // n: number of queens
  // k: board size
  def nQueen(n: Int, k: Int): List[Cells] = {

    def is_valid(c: Cell, cells: Cells): Boolean = {
      for (x <- cells)
        if (c.i == x.i |
          c.j == x.j |
          abs(c.i - c.j) == abs(x.i - x.j) |
          c.i + c.j == x.i + x.j)
          return false
      true
    }

    def aux(n: Int, k: Int): List[Cells] = {
      var rslt: List[List[Cell]] = Nil
      if (n == 1)
        for (i <- 1 to k; j <- 1 to k)
          rslt = List(Cell(i, j))::rslt
      else
        for(cells <- aux(n-1, k))
          for (i <- 1 to k; j <- 1 to k) {
            val c = Cell(i, j)
            if(c > cells.max & is_valid(c, cells))
              rslt = (Cell(i, j)::cells)::rslt
          }
      return rslt
    }
    aux(n, k)
  }
 */
}

// case class A(tag: String, load: Int) extends Ordered[A] {
//   // Required as of Scala 2.11 for reasons unknown - the companion to Ordered
//   // should already be in implicit scope
//   import scala.math.Ordered.orderingToOrdered

//   def compare(that: A): Int = (this.tag, this.load) compare (that.tag, that.load)
// }
