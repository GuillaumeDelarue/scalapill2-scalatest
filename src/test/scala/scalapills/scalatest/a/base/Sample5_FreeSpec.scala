package scalapills.scalatest.a.base

import org.scalatest.{FreeSpec, Matchers}

import scala.collection.mutable

class Sample5_FreeSpec extends FreeSpec with Matchers {

  "A Stack" - {

    "when non-empty" - {

      "should return the last element and remove it when pop is called" in {
        val stack = mutable.Stack[Int]()
        stack.push(1)
        stack.push(2)
        val oldSize = stack.size

        val result = stack.pop()

        result shouldBe 2
        stack.size shouldBe (oldSize - 1)
      }

      "should add an element when push is called" in {
        val stack = mutable.Stack[Int]()
        stack.push(1)
        stack.push(2)
        val oldSize = stack.size

        stack.push(3)

        stack.head shouldBe 3
        stack.size shouldBe (oldSize + 1)
      }
    }

    "when empty" - {
      "should throw NoSuchElementException when pop is called" in {
        val emptyStack = mutable.Stack[Int]()
        intercept[NoSuchElementException] {
          emptyStack.pop()
        }
        emptyStack shouldBe 'empty
      }
    }
  }
}
