Feature: Login functionality

   #Scenario: Successful login with valid credentials
    # Given User is on the login page
    # When user enters the username
    #And user enters the password
    #And user clicks on the login button
    #Then user is navigated to home page

	#Scenario: Unsuccessful login with invalid credentials
    #Given User is on the login page
    #When user enters the username
    #And user enters the invalid password
    #And user clicks on the login button
    #Then An error message is displayed
    
  	#Scenario Outline: Successful login with valid credentials
    #Given User is on the login page
    #When user enters the username "<username>"
    #And user enters the password "<password>"
    #And user clicks on the login button
    #Then user is navigated to home page

    #Examples:
      
      #| username | password |
      #| Admin    | admin123 |

  	#Scenario Outline: Unsuccessful login with invalid credentials
    #Given User is on the login page
    #When user enters the username "<username>"
    #And user enters the password "<password>"
    #And user clicks on the login button
    #Then An error message is displayed
    
    #Examples:
      
      #| username | password |
     # | Admin    | wrong123 |
      #| Admn     | amin123  |
    
Feature: Login functionality

  Background:
    Given User is on the login page

  @sanity
  Scenario: Login with multiple users
    When user enters credentials
      | username | password |
      | Admin    | admin123 |
    And user clicks on the login button
    Then user is navigated to home page



