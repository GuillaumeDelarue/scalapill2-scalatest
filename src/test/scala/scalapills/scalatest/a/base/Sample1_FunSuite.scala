package scalapills.scalatest.a.base

import org.scalatest.{FunSuite, Matchers}

import scala.collection.mutable

class Sample1_FunSuite extends FunSuite with Matchers {

  test("pop is invoked on a non-empty stack") {
    val stack = mutable.Stack[Int]()
    stack.push(1)
    stack.push(2)
    val oldSize = stack.size

    val result = stack.pop()

    result shouldBe 2
    stack.size shouldBe (oldSize - 1)
  }

  test("push is invoked on a non-empty stack") {
    val stack = mutable.Stack[Int]()
    stack.push(1)
    stack.push(2)
    val oldSize = stack.size

    stack.push(3)

    stack.head shouldBe 3
    stack.size shouldBe (oldSize + 1)
  }

  test("pop is invoked on an empty stack") {
    val emptyStack = mutable.Stack[Int]()
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
    emptyStack shouldBe 'empty
  }
}
