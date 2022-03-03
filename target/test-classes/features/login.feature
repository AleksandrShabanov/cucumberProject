Feature: feature to test login functionality


  Scenario: Login as a valid user
    Given user is on login page
    When user enters username 'admin' and password 'admin'
    And user clicks on login button
    Then check valid login using fName 'Ivan' and lName 'Petrov'

    Scenario: Login as a valid user with an incorrect password
      Given user is on login page
      When user enters username 'admin' and password 'adminadmin'
      And user clicks on login button
      Then check invalid login using string 'You have entered an invalid username or password!'


