package scalaByExample 

object Ch6 extends App {
  var empt = EmptySet
  val a = new NonEmptySet(10, empt, empt)
  var b = new NonEmptySet(15, empt, empt) incl 8 incl 19
  println(b)
  println(b excl 8)
}


abstract class IntSet {
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
  def excl(x: Int): IntSet
  def union(a: IntSet): IntSet
  def intersect(a: IntSet): IntSet
  def isEmpty: Boolean
}


object EmptySet extends IntSet {
  def contains(x: Int) = false
  def incl(x: Int) = new NonEmptySet(x, EmptySet, EmptySet)
  def excl(x: Int) = EmptySet 
  def union(a: IntSet) = a
  def intersect(a: IntSet) = EmptySet
  def isEmpty = true

  override def toString = {
    ""
  }
}


class NonEmptySet(val x: Int, val l: IntSet, val r: IntSet) extends IntSet {

  def isEmpty = false

  def contains(u: Int): Boolean  = {
    if (u < x)
      return l contains u 
    else if (u > x)
      return r contains u
    else
      return true
  }

  def incl(u: Int): NonEmptySet = {
    if (u < x)
      new NonEmptySet(x, l incl u, r)
    else if(u > x)
      new NonEmptySet(x, l, r incl u)
    else
      this
  }

  def excl(y: Int) =  {
    if (y == x)
      l union r
    else if (y < x)
      new NonEmptySet(x, l excl y, r)
    else 
      new NonEmptySet(x, l, r excl y)
  }

  def union(s: IntSet): IntSet = l union r union (s incl x)

  def intersect(s: IntSet) = if (s contains x)
    new NonEmptySet(x, l intersect s, r intersect s)
  else
    (l union r) intersect s
  

  override def toString = {
    l + " " + x + " " + r 
  }
}
