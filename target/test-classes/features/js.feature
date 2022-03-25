@regression
Feature: feature to test js functionality

  Scenario: Get the coordinates of the jumping div (with a red border and the text ‘Find me !’ inside).
  Enter the coordinates into the input fields and press ‘Process’.
  Handle the alert and verify that the message ‘Whoo Hoooo! Correct!’ is displayed.

    Given type to input with name 'j_username' text: 'admin'
    And type to input with name 'j_password' text: 'admin'
    And user clicks on 'Login' button
    When user at Home Page clicks on 'JS test page'
    Then enter coordinates
    And check is 'Whoo Hoooo! Correct!' displayed