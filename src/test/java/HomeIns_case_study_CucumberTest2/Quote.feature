@tag
Feature: Getting a Successful New Quote
  	Submit information of location, homeowner information and property details to get a new Quote for the User

  @tag1
  Scenario: Getting a New Quote
    Given Access the homeinsurance website
    
    Then Login into the website
    
    And Get redirected to Get Quote navigation page and fill the form
  	
 		Then Get redirected to Homeowner Information page and fill the form
  
  	And Get redirected to property details page and fill the form
  
  	Then Get redirected on coverage details page and fill the form
  
  	And Get redirected to quote details page
  	
  	 Then Get redirected to quote summary page
  	 
  	 And Get redirected to buy quote page
	
		Then Get redirected to policy confirmation page successfully and logout  