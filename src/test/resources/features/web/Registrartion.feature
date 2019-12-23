Feature: New user registration

  Scenario: Fill the  registration form in ToolQA
    Given  I am on a new user registration page
    When I enter valid data on the page
      | First name | Last name | Gender | Year of Experience | Date       | Profession    | Automation Tool    | Continents | Continents – Multiple Select | Selenium Commands                                     |
      | Akanksha   | Gupta     | Female | 1                  | 16-12-2019 | Manual Tester | Selenium Webdriver | Africa     | Asia,Europe,Australia        | Browser Commands,Navigation Commands,Switch Commands, |
    Then the user registration should be successfully






