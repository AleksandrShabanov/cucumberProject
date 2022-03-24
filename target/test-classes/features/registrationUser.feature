Feature: feature to test registration user functionality

  Scenario: Register a new user, logout, and verify that the user can login
    Given user is on login page clicks on 'Register as a new user' link
    And user enters his data to <text field> and type <text>
      | name            | killerFrog |
      | fname           | John       |
      | lname           | Johnson    |
      | password        | qwerty     |
      | passwordConfirm | qwerty     |
    When set 'USER' role
    And user clicks on 'Register'
    When user 'Logout'
    Given type to input with name 'j_username' text: 'killerFrog'
    And type to input with name 'j_password' text: 'qwerty'
    When user clicks on 'Login' button
    Then verify that the user with name 'John' and last name 'Johnson' is logged in

  Scenario: Register as a regular user, verify that the regular user can see the applications but cannot upload them.
    Given user is on login page clicks on 'Register as a new user' link
    And user enters his data to <text field> and type <text>
      | name            | killerFrog |
      | fname           | John       |
      | lname           | Johnson    |
      | password        | qwerty     |
      | passwordConfirm | qwerty     |
    When set 'USER' role
    And user clicks on 'Register'
    Then verify that the user with name 'John' and last name 'Johnson' is logged in
    Then verify that the user can see the app but cannot upload them

  Scenario: Register a new user, and verify that the user is logged in
    Given user is on login page clicks on 'Register as a new user' link
    And user enters his data to <text field> and type <text>
      | name            | killerFrog |
      | fname           | John       |
      | lname           | Johnson    |
      | password        | qwerty     |
      | passwordConfirm | qwerty     |
    When set 'USER' role
    And user clicks on 'Register'
    Then verify that the user with name 'John' and last name 'Johnson' is logged in



