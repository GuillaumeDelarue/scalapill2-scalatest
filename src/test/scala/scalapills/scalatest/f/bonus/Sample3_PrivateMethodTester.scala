package scalapills.scalatest.f.bonus

import org.scalatest.{Matchers, PrivateMethodTester, WordSpec}

class Sample3_PrivateMethodTester extends WordSpec with Matchers with PrivateMethodTester {

  case class Person(name: String, age: Int)

  "A private method" should {

    "be testable" in {

      val functionUnderTest = PrivateMethod[Int]('addValues)

      val result = ObjectUnderTest invokePrivate functionUnderTest(1, 2)

      result shouldBe 3
    }
  }
}


object ObjectUnderTest {
  private def addValues(x: Int, y: Int) = x + y
}
