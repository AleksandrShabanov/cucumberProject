Feature: feature to test login functionality

  Scenario: Login as a valid user
    Given user enters username 'admin' and password 'admin'
    When user clicks on 'Login' button
    Then check valid login using fName 'Ivan' and lName 'Petrov'

  Scenario: Login as a valid user with an incorrect password
    Given user enters username 'admin' and password 'adminadmin'
    When user clicks on 'Login' button
    Then check invalid login using string 'You have entered an invalid username or password!'


