import io.cucumber.java8.En
import io.kotest.matchers.shouldBe

class StepDefs : En {
    init {
        var valor1: Int = 0
        var valor2: Int = 0
        var result: Int = 0

        Given("I have {int}") { valor: Int ->
            valor1 = valor
        }
        And("I also have {int}") { valor: Int ->
            valor2 = valor
        }
        When("I add them") {
            result = soma(valor1, valor2)
        }
        Then("I get {int}") { r: Int ->
            r shouldBe result
        }

    }
}
