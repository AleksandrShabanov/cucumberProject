Feature: feature to test registration developer functionality

  Scenario: Register as a developer, verify that the developer can open the page to upload an application.
    Given user is on login page clicks on 'Register as a new user' link
    And user enters his data to <text field> and type <text>
      | name            | pif-paf |
      | fname           | Spock   |
      | lname           | Johnson |
      | password        | 123     |
      | passwordConfirm | 123     |
    When set 'DEVELOPER' role
    And user clicks on 'Register'
    Then verify that the user with name 'Spock' and last name 'Johnson' is logged in
    Then click on 'My applications' and 'Click to add new application' and verify upload 'New application'