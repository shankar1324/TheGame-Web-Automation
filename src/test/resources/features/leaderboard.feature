@regression
Feature: Verify leaderboard

  Scenario Outline: Verify complete challenges functionality
    Given I am on the homepage of the application
    When I click on Login button
    And I enter "<username>" in Username field in login popup
    And I enter "<password>" in Password field in login popup
    And I click on Login warrior button
    And I click on Start your journey button
    And I click on "<battlefield>" battlefield
    And I click on Start button
    And I select option 1 for challenge 1
		And I click on Check your final score button
		Then I should be navigated to leaderboard page for "<username>"

    Examples: 
      | username  | password |	battlefield			|
      | shankar01 | test123  |	Take the bus		|