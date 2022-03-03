Feature: feature to test registration functionality

  Scenario: Register a new user, and verify that the user is logged in
    Given user is on login page
    And user clicks on register link
#    And create user
#      | username   | fName | lName   | password | confirmPassword |
#      | killerFrog | John  | Johnson | qwerty   | qwerty          |
    When user enters username 'Skywalker', fName 'Luke', lName 'Skywalker', password 'qwerty' and confirmPassword 'qwerty'
    And user clicks on register button
    Then verify that the user is logged in




