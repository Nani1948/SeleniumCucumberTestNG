#Author: your.email@your.domain.com
Feature: verify the login functionality

Background: 
    Given User open salesforce application
Scenario: Login with valid username and no password
    Given User is on the "loginpage"
    When User enters username as "username1"
    And User clears the password field
    When User clicks on the Login button
    Then The error message should be displayed


Scenario: Login to Salesforce application
          Given User is on the "loginpage"
           When User enters username as "username1"
           And User enters password as "password1"
           When User clicks on the Login button
           Then The home page should be displayed