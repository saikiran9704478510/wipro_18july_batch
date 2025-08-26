Feature: SauceDemo E2E Test

  Background: 
  Given User is on SauceDemo login page

  @validLogin
  Scenario: Successful login and product checkout
    When User enters valid username and password
    Then User is navigated to Products page
    When User adds a product to the cart
    And User proceeds to checkout
    And User enters checkout details
    And User completes the purchase
    Then Order confirmation message is displayed

  @invalidLogin
  Scenario: Login with invalid credentials
    When User enters invalid username and password
    Then An error message is displayed on SauceDemo
