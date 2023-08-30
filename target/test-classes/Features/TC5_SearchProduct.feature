@SearchProduct
Feature: SearchProduct Module API Automation

  Scenario: Verify User Get SearchProduct through  api
    Given User add headers for to SearchProduct
    When User add request body "<text>" for get SearchProduct
    When User send "POST" request for SearchProduct endpoint
    Then User Should Verify the status code is 200
    And User Should Verify the SearchProduct response message matches "OK"
