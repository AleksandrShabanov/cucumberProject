Feature: feature to test applications functionality

  Scenario: Create a new application without images. Verify that it is displayed correctly and can be downloaded.
    Given user enters username 'admin' and password 'admin'
    When user clicks on 'Login' button
    And at Home Page click on 'My applications'
    And at My applications page 'Click to add new application'
    When create new app with name 'newAppAVS123' and description 'This is a new app'
    And click on 'Create'
    When Verify that it is displayed
    Then check the user can download new app