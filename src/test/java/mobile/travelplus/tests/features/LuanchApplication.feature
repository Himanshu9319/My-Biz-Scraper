@Regression
Feature: Mobile


  @Test
  Scenario Outline: User  login in web application
    Given Login application with employee "<username>"
    Then Click send otp button
    When Enter otp on first box "<otp>"
    Examples:
      | username | otp    |
      | employee | 123456 |


  Scenario: Book flight one way flight
    Given Scroll the payment page
    When Click on create tripbutton
    When Click on add flight button
    When Select date



