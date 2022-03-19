Feature: feature to test ajax functionality

  Scenario: Enter two valid numbers, click ‘Sum’, wait for the result and check if the result is correct
    Given the user enters username 'admin' and password 'admin'
    And the user clicks on login button
    When user at Home Page clicks on ajax test page link
    And user at Ajax Page enters X '2' and Y '2'
    And user clicks on Sum button
    Then check if the result is correct if X '2' and Y '2'

  Scenario: Enter one valid number and one string (not a number), click ‘Sum’, wait for the result, and verify that the message ‘Incorrect data’ appears
    Given the user enters username 'admin' and password 'admin'
    And the user clicks on login button
    When user at Home Page clicks on ajax test page link
    And user at Ajax Page enters X '2' and Y 'two'
    And user clicks on Sum button
    Then check if the result is incorrect if X '2' and Y 'two'