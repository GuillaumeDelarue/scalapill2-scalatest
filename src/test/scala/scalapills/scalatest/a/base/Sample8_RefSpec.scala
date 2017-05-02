package scalapills.scalatest.a.base

import org.scalatest.Matchers
import org.scalatest.refspec.RefSpec

import scala.collection.mutable

class Sample8_RefSpec extends RefSpec with Matchers {

  object `A Stack` {

    object `when non-empty` {

      def `should return the last element and remove it when pop is called`() {
        val stack = mutable.Stack[Int]()
        stack.push(1)
        stack.push(2)
        val oldSize = stack.size

        val result = stack.pop()

        result shouldBe 2
        stack.size shouldBe (oldSize - 1)
      }

      def `should add an element when push is called`() {
        val stack = mutable.Stack[Int]()
        stack.push(1)
        stack.push(2)
        val oldSize = stack.size

        stack.push(3)

        stack.head shouldBe 3
        stack.size shouldBe (oldSize + 1)
      }
    }

    object `when empty` {

      def `should throw NoSuchElementException when pop is called`() {
        val emptyStack = mutable.Stack[Int]()
        intercept[NoSuchElementException] {
          emptyStack.pop()
        }
        emptyStack shouldBe 'empty
      }
    }

  }

}
