@tag
Feature: New user registration 
  I want to go to HomeInsurance website to register as a new user for a successful loggin

  @tag1
  Scenario: Create a new user
  	Given Open HomeInsurance page 
  	Then Click on the Register Here button
  	And Enter a valid user name
  	Then Enter a valid password
  	And ReEnter the password to confirm it
  	Then click the Register button
  
  	