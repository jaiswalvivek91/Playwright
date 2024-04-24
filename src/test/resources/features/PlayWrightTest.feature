Feature: This feature will use  Playwright Automation Tool

  @testPW
  Scenario: Tes1
    Given User navigate to VMO site
    And user check if VMO site is loaded or not
    When user enter username and password
    And user close the browser


  @test1
  Scenario Outline: Verify flight booking for users
    Given User navigates to flight booking application
    And user check if flight booking application is loaded or not
    When user selects "<departure>" and "<destination>" city
    And click on Find Flights button
    And user choose flight to reserve ticket
    And user enters all passenger details
    And clicks on Purchase Flight button
    Then user validates purchase details
    Examples:
      | departure   | destination |
      | Paris       | Rome        |
      | Boston      | Berlin      |


  @test
  Scenario Outline: Verify departure and destination dropdowns have all expected cities
    Given User navigates to flight booking application
    Then User validates "<departure>" and "<destination>" cities available
    Examples:
      | departure                                                         | destination                                           |
      | Paris,Philadelphia,Boston,Portland,San Diego,Mexico City,São Paolo| Buenos Aires,Rome,London,Berlin,New York,Dublin,Cairo |


