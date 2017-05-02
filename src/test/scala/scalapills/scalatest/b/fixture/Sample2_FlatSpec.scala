package scalapills.scalatest.b.fixture

import org.scalatest.{Matchers, Outcome, fixture}

import scala.collection.mutable

class Sample2_FlatSpec extends fixture.FlatSpec with Matchers {

  type FixtureParam = mutable.Stack[Int]

  def withFixture(test: OneArgTest): Outcome = {
    val stack = mutable.Stack[Int]()
    stack.push(1)
    stack.push(2)
    test(stack)
  }

  behavior of "a non-empty stack"

  it should "return the last element and remove it when pop is called" in { stack =>
    val oldSize = stack.size

    val result = stack.pop()

    result shouldBe 2
    stack.size shouldBe (oldSize - 1)
  }

  it should "add an element when push is called" in { stack =>
    val oldSize = stack.size

    stack.push(3)

    stack.head shouldBe 3
    stack.size shouldBe (oldSize + 1)
  }

  behavior of "an empty stack"

  it should "throw NoSuchElementException when pop is called" in { () =>
    val emptyStack = mutable.Stack[Int]()
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
    emptyStack shouldBe 'empty
  }
}
