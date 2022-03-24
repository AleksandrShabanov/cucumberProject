Feature: feature to test registration user functionality

  Background: we create user
    Given we create user
      | username        | killerFrog |
      | fName           | John       |
      | lName           | Johnson    |
      | password        | qwerty     |
      | confirmPassword | qwerty     |
      | role            | USER       |
    And user is on login page clicks on 'Register as a new user' link
    And the user enters his data
    And user clicks on 'Register'

  Scenario: Register a new user, and verify that the user is logged in
    Then verify that the user is logged in

  Scenario: Register a new user, logout, and verify that the user can login
    When user 'Logout'
    And login again
    Given type to input with name 'j_username' text: 'admin'
    And type to input with name 'j_password' text: 'admin'
    When user clicks on 'Login' button
    Then verify that the user is logged in

  Scenario: Register as a regular user, verify that the regular user can see the applications but cannot upload them.
    Then verify that the user is logged in
    Then verify that the user can see the app but cannot upload them




