@regression
Feature: Login

Scenario Outline: Verify user is able to login successfully
		Given I am on the homepage of the application
		When I click on Login button
		And I enter "<username>" in Username field in login popup
		And I enter "<password>" in Password field in login popup
		And I click on Login warrior button
		Then I should verify that "<username>" is logged in successfully
		
		Examples:
		|	username	|	password	|
		| shankar01	|	test123		|