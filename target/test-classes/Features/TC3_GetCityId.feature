@City
Feature: City Module API Automation

  Scenario: Verify User Get CityList through  api
    Given User add headers for to CityList
    When User add request body stateid for get CityList
    When User send "POST" request for CityList endpoint
    Then User Should Verify the status code is 200
    And User Should verify the CityList response message matches "Yercaud" and save cityid