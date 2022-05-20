@regression
Feature: SignUp

  Scenario: Verify if clicking on Register button displays the popup for SignUp
    Given I am on the homepage of the application
    When I click on Register button
    Then I should be presented with a popup for signup

  Scenario Outline: Verify that user is able to signup successfully
    Given I am on the homepage of the application
    When I click on Register button
		And I enter "<username>" in Username field
		And I enter "<password>" in Password field
		And I enter "<password>" in Repeat Password field
		And I click on Sign Up button
		Then I should verify that user "<username>" is created successfully
		
		Examples:
		|	username	|	password	|
		|	shankar14	| test123		|