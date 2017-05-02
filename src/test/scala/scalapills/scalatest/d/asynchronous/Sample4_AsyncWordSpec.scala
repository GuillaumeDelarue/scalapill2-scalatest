package scalapills.scalatest.d.asynchronous

import org.scalatest.{AsyncWordSpec, Matchers, ParallelTestExecution}

import scala.collection.mutable
import scala.concurrent.{ExecutionContext, Future}

class Sample4_AsyncWordSpec extends AsyncWordSpec with Matchers with ParallelTestExecution  {
  implicit override def executionContext: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global

  "A Stack" should {

    "asynchronously return the last element and remove it when pop is called" in {
      val stack = mutable.Stack[Int]()
      stack.push(1)
      stack.push(2)
      val oldSize = stack.size

      val futureResult = Future {
        Thread.sleep(3000)
        stack.pop()
      }

      futureResult map { result =>
        result shouldBe 2
        stack.size shouldBe (oldSize - 1)
      }
    }

    "immediately add an element when push is called" in {
      val stack = mutable.Stack[Int]()
      stack.push(1)
      stack.push(2)
      val oldSize = stack.size

      stack.push(3)

      stack.head shouldBe 3
      stack.size shouldBe (oldSize + 1)
    }

    "throw NoSuchElementException when pop is called on an empty stack" in {
      val emptyStack = mutable.Stack[Int]()
      intercept[NoSuchElementException] {
        emptyStack.pop()
      }
      emptyStack shouldBe 'empty
    }
  }
}