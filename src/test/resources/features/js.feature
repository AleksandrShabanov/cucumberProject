Feature: feature to test js functionality

  Scenario: Get the coordinates of the jumping div (with a red border and the text ‘Find me !’ inside).
  Enter the coordinates into the input fields and press ‘Process’.
  Handle the alert and verify that the message ‘Whoo Hoooo! Correct!’ is displayed.

    Given enter username 'admin' and password 'admin'
    And click on login button
    When user at Home Page clicks on js link
    Then enter coordinates
    And check is Alert displayed