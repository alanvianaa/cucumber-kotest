# cucumber and kotest
Cucumber test in kotlin

### documentation
-> [Cucumber kotlin](https://cucumber.io/docs/installation/kotlin/)

-> [Kotest](https://kotest.io/)

# Examples

### kotlin function example
```kotlin
fun soma(n1: Int, n2: Int): Int {
    return n1 + n2
}

fun subtracao(n1: Int, n2: Int) {
    n1 - n2
}
```
### Cucumber steps example

```kotlin
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
```

### Cucumber feature example

```gherkin
Feature: Simple test using cucumber

  Scenario: Addition
    Given I have 2
    And I also have 2
    When I add them
    Then I get 4
```
