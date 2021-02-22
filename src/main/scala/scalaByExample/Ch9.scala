package scalaByExample
import scala.language.postfixOps

import scala.math._

object Ch9 extends App {
  val xs = List(5, 2, 1, 0, -9, 3, 1)
  println(xs)
  println(squareList(xs))
  println(squareList2(xs))
  //println(mergesort(xs))


  def mergesort[T <% Ordered[T]](xs: List[T]): List[T] = {

    def merge(xs: List[T], ys: List[T]): List[T] = {
      if (xs isEmpty)
        return ys
      if(ys isEmpty)
        return xs 
      if(xs.head <= ys.head)
        return xs.head::merge(xs.tail, ys)
      else
        return ys.head::merge(xs, ys.tail)
    }

    val n = xs.length

    if (n < 2)
      return xs

    if (n == 2)
      return if (xs.head <= xs.last) xs else xs.reverse

    merge(mergesort(xs.take(n/2)), mergesort(xs.drop(n/2)))
  }

  def squareList(xs: List[Int]): List[Int] = xs match {
    case Nil => Nil 
    case y::ys => y*y::squareList(ys)
  }

  def squareList2(xs: List[Int]) = xs map (x => x*x)

  // def squareList(xs: List[Int]): List[Int] = xs match { case List() => ?? case y :: ys => ?? }
  // def squareList(xs: List[Int]): List[Int] = xs map ??


  def isort[T <% Ordered[T]](xs: List[T]): List[T] =
    if (xs.isEmpty) Nil
    else insert(xs.head, isort(xs.tail))


def insert[T <% Ordered[T]](x: T, xs: List[T]): List[T] = xs match {
  case Nil => List(x)
  case y::ys => if (x < y) x::xs else y::insert(x, ys)
}


  def len2(xs: Any): Int = xs match {
      case Nil => 0 
      case z::zs => 1 + len2(zs)
  }

  def len[T](xs: T): Int = {
    def iterate[T](ys: T, accum: Int): Int = ys match {
      case Nil => accum
      case z::zs => iterate(zs, accum + 1)
    }
    iterate(xs, 0)
  }
}




