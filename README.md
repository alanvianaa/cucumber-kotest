# cucumber and kotest
Cucumber test in kotlin

### documentation
-> [Cucumber kotlin](https://cucumber.io/docs/guides/10-minute-tutorial/)

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

### Build Gradle (Dependencies)

```groovy
dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version"
    implementation "org.apache.commons:commons-lang3:3.11"

    testImplementation "io.kotest:kotest-runner-junit5-jvm:4.2.0.RC2"
    testImplementation 'io.cucumber:cucumber-java8:6.8.0'

}
```

### Build Gradle (Task)

``` groovy
configurations {
    cucumberRuntime {
        extendsFrom testImplementation
    }
}

task cucumber() {
    dependsOn assemble, compileTestJava
    doLast {
        javaexec {
            main = "io.cucumber.core.cli.Main"
            classpath = configurations.cucumberRuntime + sourceSets.main.output + sourceSets.test.output
            args = ['--plugin', 'pretty', '--glue', 'hellocucumber', 'src/test/resources']
        }
    }
}
```
Note: `hellocucumber` is the package with steps cucumber made in kotlin