package scalapills.scalatest.f.bonus

import org.scalatest.{EitherValues, Matchers, OptionValues, WordSpec}

class Sample2_OptionEitherValues extends WordSpec with Matchers with OptionValues with EitherValues {

  case class Person(name: String, age: Int)

  "OptionValues" should {
    "fail with a proper exception providing a correct stack depth" in {
//      val something: Option[String] = None
      val something = Option("valid")

      something.value shouldBe "valid"
    }
  }

  "EitherValues" should {
    "fail with a proper exception providing a correct stack depth" in {
//      val something: Either[String, Int] = Right(1)
      val something: Either[String, Int] = Left("valid")

      something.left.value shouldBe "valid"
    }
  }
}
