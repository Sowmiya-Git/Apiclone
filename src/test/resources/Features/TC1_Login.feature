@Login
Feature: Login Module API Automation

  Scenario: Get User logtoken from login endpoint
    Given User add header
    When User add basic authentication for login
    And User send "POST" request for login endpoint
    Then User Should Verify the status code is 200
    And User Should verify the login response body firstName present as "sowmiya" and get the logtoken
