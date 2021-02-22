package scalaByExample
import scala.language.postfixOps

object Ch8 extends App {
  val xs = new EmptyStack[Int]()
  println(xs push 10 push 20 top)
}

abstract class Stack[T]() {
  def isEmpty(): Boolean
  def top(): T
  def pop(): Stack[T] 
  def push(x: T) = new NonEmptyStack[T](x, this)
}

class EmptyStack[T]() extends Stack[T] {
  def isEmpty = true 
  def top() = throw new Exception("EmptyStack.top")
  def pop() = throw new Exception("EmptyStack.pop")
   //def top() = error("EmptyStack.top")
  // def pop() = error("EmptyStack.pop")
}

class NonEmptyStack[T](x: T, rest: Stack[T]) extends Stack[T] {
  def isEmpty = true 
  def top() = x 
  def pop() = rest
}
