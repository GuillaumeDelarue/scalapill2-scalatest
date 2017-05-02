package scalapills.scalatest.a.base

import org.scalatest.{FeatureSpec, GivenWhenThen, Matchers}

import scala.collection.mutable

class Sample7_FeatureSpec extends FeatureSpec with Matchers with GivenWhenThen {

  info("As a business user")
  info("I want to be able to describe this test")
  info("So I can understand what it does")
  info("And know it works as expected")


  feature("Stack") {

    scenario("return the last element and remove it when pop is called in a non-empty stack") {

      Given("a non-empty stack")
      val stack = mutable.Stack[Int]()
      stack.push(1)
      stack.push(2)
      val oldSize = stack.size

      When("pop is called")
      val result = stack.pop()

      Then("last element is returned and removed from the stack")
      result shouldBe 2
      stack.size shouldBe (oldSize - 1)
    }

    scenario("add an element when push is called") {

      Given("a non-empty stack")
      val stack = mutable.Stack[Int]()
      stack.push(1)
      stack.push(2)
      val oldSize = stack.size

      When("push is called")
      stack.push(3)

      Then("the pushed element is added to the stack")
      stack.head shouldBe 3
      stack.size shouldBe (oldSize + 1)
    }

    scenario("throw NoSuchElementException when pop is called in an empty stack") {

      Given("An empty stack")
      val emptyStack = mutable.Stack[Int]()

      When("pop is called")
      Then("NoSuchElementException is thrown")
      intercept[NoSuchElementException] {
        emptyStack.pop()
      }
      emptyStack shouldBe 'empty
    }
  }
}
