Feature: Testing of login feature

  Background: 
  Given user is on login page

  Scenario: validate login with valid data
    When user enter valid username and password
    And click on login button
    Then user redirect to Home page

  Scenario: Validatde login with invalid data
    When user enter invalid username and password
    And click on login button
    Then error message shows
