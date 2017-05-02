package scalapills.scalatest.f.bonus

import org.scalatest.{Inside, Matchers, WordSpec}

import scala.collection.mutable

class Sample1_Inside extends WordSpec with Matchers with Inside {

  case class Person(name: String, age: Int)

  "A Person" should {

    "do something" in {
      val someone = Person(name = "Fred", age = 25)

      inside(someone) { case Person(name, age) =>
        name shouldBe "Fred"
        age should be > 18
      }
    }
  }
}
