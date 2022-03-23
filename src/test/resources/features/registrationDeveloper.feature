Feature: feature to test registration developer functionality

  Scenario: Register as a developer, verify that the developer can open the page to upload an application.
    Given we create user
      | username        | superAdmin |
      | fName           | Jack       |
      | lName           | Jackson    |
      | password        | qwerty     |
      | confirmPassword | qwerty     |
      | role            | DEVELOPER  |
    And user is on login page clicks on 'Register as a new user' link
    When the user enters his data
    And user clicks on 'Register'
    Then click on 'My applications' and 'Click to add new application' and verify upload 'New application'