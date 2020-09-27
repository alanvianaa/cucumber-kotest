Feature: Simple test using cucumber

  Scenario: Addition
    Given I have 2
    And I also have 2
    When I add them
    Then I get 4

  Scenario: Addition2
    Given I have 2
    And I also have 3
    When I add them
    Then I get 5

  Scenario: Addition3
    Given I have 2
    When I add them
    Then I get 2