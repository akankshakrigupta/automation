Feature:  Perform all  possible negative scenario for login functionality


  Scenario Outline: Login functionality for ATS project
    Given user navigates to ATS
    When When I enter Username as "<emailid>" and Password as "<password>"
    Then Then login should be unsuccessful
    Examples:
      | emailid                   | password |
      | akankshakkgupta@gmail.com | secret   |
      | akankshakgupta@gmail.com  | secret1  |
      | akankshak1gupta@gmail.com | Secret   |