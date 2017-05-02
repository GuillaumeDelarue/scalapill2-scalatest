package scalapills.scalatest.a.base

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

class Sample2_FlatSpec extends FlatSpec with Matchers {

  behavior of "a non-empty stack"

  it should "return the last element and remove it when pop is called" in {
    val stack = mutable.Stack[Int]()
    stack.push(1)
    stack.push(2)
    val oldSize = stack.size

    val result = stack.pop()

    result shouldBe 2
    stack.size shouldBe (oldSize - 1)
  }

  it should "add an element when push is called" in {
    val stack = mutable.Stack[Int]()
    stack.push(1)
    stack.push(2)
    val oldSize = stack.size

    stack.push(3)

    stack.head shouldBe 3
    stack.size shouldBe (oldSize + 1)
  }

  "an empty stack" should "throw NoSuchElementException when pop is called" in {
    val emptyStack = mutable.Stack[Int]()
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
    emptyStack shouldBe 'empty
  }
}
