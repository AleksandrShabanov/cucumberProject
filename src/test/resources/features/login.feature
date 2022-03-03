Feature: feature to test login functionality


  Scenario Outline: check login is successful with valid and invalid credentials
    Given user is on login page
    When enters <username> and <password>
    And clicks on login button
    Then check valid or invalid login using <fName> and <lName>

    Examples:
      | username | password   |
      | admin    | admin      |
      | admin    | adminadmin |

    Examples:
      | fName | lName  |
      | Ivan  | Petrov |



