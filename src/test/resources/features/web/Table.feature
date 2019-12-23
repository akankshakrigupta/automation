Feature: Calculate number of entries in the table
  Scenario: Calculate number of entries
    Given navigate to Table url
    When verify number of entries
    Then entries equal to number of entries