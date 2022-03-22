Feature: feature to test registration functionality

  Scenario: Register a new user, and verify that the user is logged in
    Given we create user
      | username        | killerFrog |
      | fName           | John       |
      | lName           | Johnson    |
      | password        | qwerty     |
      | confirmPassword | qwerty     |
      | role            | USER       |
    And user is on login page clicks on register link
    When the user enters his data
    And user clicks on register button
    Then verify that the user is logged in

  Scenario: Register a new user, logout, and verify that the user can login
    Given we create user
      | username        | killerFrog |
      | fName           | John       |
      | lName           | Johnson    |
      | password        | qwerty     |
      | confirmPassword | qwerty     |
      | role            | USER       |
    And user is on login page clicks on register link
    When the user enters his data
    And user clicks on register button
    When user logout
    Then verify that the user can login

  Scenario: Register as a developer, verify that the developer can open the page to upload an application.
    Given we create user
      | username        | superAdmin |
      | fName           | Jack       |
      | lName           | Jackson    |
      | password        | qwerty     |
      | confirmPassword | qwerty     |
      | role            | DEVELOPER  |
    And user is on login page clicks on register link
    When the user enters his data
    And user clicks on register button
    Then click on 'My applications' and verify upload 'New application'

  Scenario: Register as a regular user, verify that the regular user can see the applications but cannot upload them.
    Given we create user
      | username        | killerFrog |
      | fName           | John       |
      | lName           | Johnson    |
      | password        | qwerty     |
      | confirmPassword | qwerty     |
      | role            | USER       |
    And user is on login page clicks on register link
    When the user enters his data
    And user clicks on register button
    Then verify that the user is logged in
    Then verify that the user can see the app but cannot upload them


