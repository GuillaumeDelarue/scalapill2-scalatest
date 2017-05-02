package scalapills.scalatest.e.selenium

import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.scalatest.concurrent.Eventually
import org.scalatest.selenium.WebBrowser
import org.scalatest.{Matchers, WordSpec}

class Sample_Selenium extends WordSpec with Matchers with Eventually with WebBrowser {
  implicit val webDriver = new HtmlUnitDriver
  //  implicit val webDriver = new ChromeDriver(options...)
  //  implicit val webDriver = new SafariDriver(options...)

  "Google website" should {

    "allow search queries" in {

      go to "http://www.google.com"
      click on "q"
      textField("q").value = "Search Query"
      submit()

      eventually {
        pageTitle shouldBe "Search Query - Google Search"
      }
    }
  }
}
