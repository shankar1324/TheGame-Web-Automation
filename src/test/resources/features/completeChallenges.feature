@regression
Feature: Complete challenges

  Scenario Outline: Verify complete challenges functionality
    Given I am on the homepage of the application
    When I click on Login button
    And I enter "<username>" in Username field in login popup
    And I enter "<password>" in Password field in login popup
    And I click on Login warrior button
    And I click on Start your journey button
    Then I should be navigated to the game home page
    When I click on "<battlefield>" battlefield
    Then I should be navigated to "<battlefield>" battlefield
    When I click on Start button
    Then I should be navigated to Take the bus challenge
    When I select option 1 for challenge 1
    Then I verify that answer should be evaluated

    Examples: 
      | username  | password |	battlefield			|
      | shankar01 | test123  |	Take the bus		|
