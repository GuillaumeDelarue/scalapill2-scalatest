package scalapills.scalatest.c.fixturecontext

import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

class Sample2_FlatSpec extends FlatSpec with Matchers {

  trait NonEmptyStackSetup {
    val stack = mutable.Stack[Int]()
    stack.push(1)
    stack.push(2)
    val oldSize = stack.size
  }

  trait EmptyStackSetup {
    val emptyStack = mutable.Stack[Int]()
  }

//  behavior of "a non-empty stack"

  "a non-empty stack" should "return the last element and remove it when pop is called" in new NonEmptyStackSetup {
    val result = stack.pop()

    result shouldBe 2
    stack.size shouldBe (oldSize - 1)
  }

  it should "add an element when push is called" in new NonEmptyStackSetup {
    stack.push(3)

    stack.head shouldBe 3
    stack.size shouldBe (oldSize + 1)
  }

  behavior of "an empty stack"

  it should "throw NoSuchElementException when pop is called" in new EmptyStackSetup {
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
    emptyStack shouldBe 'empty
  }

  // -------------

  behavior of "test multiple contexts"

  it should "use different contexts at the same time" in new NonEmptyStackSetup with EmptyStackSetup {
    stack.head shouldBe 2
    emptyStack shouldBe 'empty
  }
}
