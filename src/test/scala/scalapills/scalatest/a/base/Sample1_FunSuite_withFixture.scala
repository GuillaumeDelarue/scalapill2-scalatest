package scalapills.scalatest.a.base

import org.scalatest.{Failed, FunSuite, Matchers, Outcome}

import scala.collection.mutable

class Sample1_FunSuite_withFixture extends FunSuite with Matchers {

  override protected def withFixture(test: NoArgTest): Outcome = {
    println("SOME SETUP")
    try super.withFixture(test) match {
      case failed: Failed =>
        println("** FAILED **")
        failed
      case other => other
    }
    finally println("SOME CLEANUP")
  }

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
