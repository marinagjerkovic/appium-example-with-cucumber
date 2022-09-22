Feature: Calculator

  Scenario: Verify that 1 + 2 equals 3
    When user clicks number 1
    And user clicks button plus
    And user clicks number 2
    Then verify number 4 is displayed in result field