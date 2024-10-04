
Feature: This feature is to get the CEO name from orangeHRM app
 Scenario Outline: This is to verify CEO name
    Given user logged into HOME page
    When user clicks directory options from menu bar
    When  user selects job title as "CEO" from dropdown
    And user clicks search button
   Then user should see the CEO name AS "<CEO_Name>"
   Examples:
   |CEO_Name|
   |John Smith|