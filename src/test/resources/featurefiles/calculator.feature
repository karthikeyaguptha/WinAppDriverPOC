Feature: Windows Calculator

  @smoke
  Scenario: Add two numbers
    Given the Calculator application is launched
    When I add one and two
    Then the Calculator result should be "3"


  @smoke
  Scenario: Add two numbers
    Given the Calculator application is launched
    When I add one and two
    Then the Calculator result should be "3"