@State
Feature: State Module API Automation

  Scenario: Verify User Get StateList through  api
    Given User add headers for to StateList
    When User send "GET" request for StateList endpoint
    Then User Should Verify the status code is 200
    And User Should verify the StateList response matches "Tamil Nadu" and save stateid
