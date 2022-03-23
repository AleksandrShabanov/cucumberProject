Feature: feature to test applications functionality

  Scenario: Create a new application without images. Verify that it is displayed correctly and can be downloaded.
    Given user enters username 'admin'
    And user enters password 'admin'
    When user clicks on 'Login' button
    And at Home Page click on 'My applications'
    And at My applications page 'Click to add new application'
    When create new app with name 'newAppAVS123' and description 'This is a new app'
    And click on 'Create'
    When Verify that it is displayed
    And at Home Page click on 'Details' link
    When at Details Page click on 'Download' link
    Then check the user can download new app

  Scenario: Edit an application without images, and verify that the changes were applied.
    Given user enters username 'admin'
    And user enters password 'admin'
    When user clicks on 'Login' button
    And at Home Page click on 'Details' link
    When at Details Page click on 'Edit'
    Then verify that the changes were applied and we see 'Application edited'

  Scenario: Create a new application with an image and icon
    Given user enters username 'admin'
    And user enters password 'admin'
    When user clicks on 'Login' button
    And at Home Page click on 'My applications'
    And at My applications page 'Click to add new application'
    When create new app with name 'newAppWithImage_AVS' and description 'This is a new application with image and icon'
    When press choose file for add image
    And press choose file for add icon
    And click on 'Create'
    Then verify that app was create

  Scenario: Delete an application and verify that it has been removed
    Given user enters username 'admin'
    And user enters password 'admin'
    When user clicks on 'Login' button
    And at Home Page click on 'Details' link
    And at Details page click on 'Delete'
    Then verify that the changes were applied and we see 'Deleted'

  Scenario: confirm text on page
    Given user enters username 'admin'
    And user enters password 'admin'
    When user clicks on 'Login' button
    And at Home Page click on 'Details' link
    Then confirm text after 'Download'

  Scenario: Create an application, and download it many times
    Given user enters username 'admin'
    And user enters password 'admin'
    When user clicks on 'Login' button
    And at Home Page click on 'My applications'
    And at My applications page 'Click to add new application'
    When create new app with name 'newAppAVS123' and description 'This is a new app'
    And click on 'Create'
    And at Home Page click on 'Details new app' link
    When 'Download' file many times
    Then verify that my app in popular section