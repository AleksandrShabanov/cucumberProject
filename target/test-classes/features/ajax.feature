@regression
Feature: feature to test ajax functionality

  Scenario: Enter two valid numbers, click ‘Sum’, wait for the result and check if the result is correct
    Given type to input with name 'j_username' text: 'admin'
    And type to input with name 'j_password' text: 'admin'
    And user clicks on 'Login' button
    When user at Home Page clicks on 'Ajax test page' link
    And user at Ajax Page enters X '2' and Y '2'
    And user clicks on Sum button
    Then check if the result is correct if X '2' and Y '2'

  Scenario: Enter one valid number and one string (not a number), click ‘Sum’, wait for the result, and verify that the message ‘Incorrect data’ appears
    Given type to input with name 'j_username' text: 'admin'
    And type to input with name 'j_password' text: 'admin'
    And user clicks on 'Login' button
    When user at Home Page clicks on 'Ajax test page' link
    And user at Ajax Page enters X '2' and Y 'two'
    And user clicks on Sum button
    Then check if incorrect result field equals 'Result is: Incorrect data'