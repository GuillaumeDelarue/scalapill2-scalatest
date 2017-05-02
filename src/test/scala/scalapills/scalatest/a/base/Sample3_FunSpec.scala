package scalapills.scalatest.a.base

import org.scalatest.{FunSpec, Matchers, path}

import scala.collection.mutable

class Sample3_FunSpec extends path.FunSpec with Matchers {

  describe("A Stack") {

    describe("when non-empty") {

      val stack = mutable.Stack[Int]()
      stack.push(1)
      stack.push(2)
      val oldSize = stack.size

      it("should return the last element and remove it when pop is called") {
        val result = stack.pop()

        result shouldBe 2
        stack.size shouldBe (oldSize - 1)
      }

      it("should add an element when push is called") {
        stack.push(3)

        stack.head shouldBe 3
        stack.size shouldBe (oldSize + 1)
      }
    }

    describe("when empty") {
      it("should throw NoSuchElementException when pop is called") {
        val emptyStack = mutable.Stack[Int]()
        intercept[NoSuchElementException] {
          emptyStack.pop()
        }
        emptyStack shouldBe 'empty
      }
    }
  }
}
