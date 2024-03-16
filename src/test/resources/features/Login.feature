Feature: User Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username and password
    Then I should see the user dashboard

  Scenario: Unsuccessful login with invalid credentials
    Given I am on the login page
    When I enter invalid username and password
    Then I should see an error message