@smoketest
Feature: feature to test login functionality

  Scenario: Login as a valid user
    Given type to input with name 'j_username' text: 'admin'
    And type to input with name 'j_password' text: 'admin'
    When user clicks on 'Login' button
    Then check valid login using fName 'Ivan' and lName 'Petrov'

  Scenario: Login as a valid user with an incorrect password
    Given type to input with name 'j_username' text: 'admin'
    And type to input with name 'j_password' text: 'adminadmin'
    When user clicks on 'Login' button
    Then check invalid login using string 'You have entered an invalid username or password!'


