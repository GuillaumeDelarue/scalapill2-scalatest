package scalapills.scalatest.b.fixture

import org.scalatest.{Matchers, Outcome, fixture}

import scala.collection.mutable

class Sample1_FunSuite extends fixture.FunSuite with Matchers {

  type FixtureParam = mutable.Stack[Int]

  def withFixture(test: OneArgTest): Outcome = {
    val stack = mutable.Stack[Int]()
    stack.push(1)
    stack.push(2)
    try test(stack)
    finally {
      // optional clean-up
    }
  }

  test("pop is invoked on a non-empty stack") { stack =>
    val oldSize = stack.size
    val top = stack.pop()
    top shouldBe 2
    stack.size shouldBe (oldSize - 1)
  }

  test("push is invoked on a non-empty stack") { stack =>
    val oldSize = stack.size
    stack.push(3)
    stack.head shouldBe 3
    stack.size shouldBe (oldSize + 1)
  }

  // Example with no parameter
  test("pop is invoked on an empty stack") { () =>
    val emptyStack = mutable.Stack[Int]()
    intercept[NoSuchElementException] {
      emptyStack.pop()
    }
    emptyStack shouldBe 'empty
  }
}
