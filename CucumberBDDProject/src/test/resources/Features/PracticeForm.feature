Feature: Automation Practice Form

  @form
  Scenario: Fill automation practice form successfully
    Given User is on the automation practice form page
    When User enters name "Madan" and email "sai@gmail.com"
    And User selects gender "Male"
    And User enters mobile number "123456789"
    And User enters date of birth "2002-04-11"
    And User enters subjects "maths, physics, java selenium python, software testing"
    And User selects hobby "Reading"
    And User uploads picture
    And User enters current address "Vijayawada, Andhra Pradesh"
    And User selects state "NCR" and city "Agra"
    And User clicks on login button
    Then Form should be submitted successfully