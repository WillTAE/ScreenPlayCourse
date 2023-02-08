Feature: Login to Sauce home page

  @qa
  Scenario: Success login to Sauce home page
    Given William is a Sauce Customer
    When He tries to login
    Then He should see to products list

  @inProgress
  Scenario Outline: Success login to Sauce home page
    Given William is a Sauce Customer
    When He tries to login with username <userName> and password <password>
    Then He should see to products list
    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |