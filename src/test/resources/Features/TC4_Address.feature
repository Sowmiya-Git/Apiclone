@Address
Feature: Address Module API Automation

  Scenario Outline: Verify add user address to the application through  api
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body for add new address "<firstName>","<LastName>","<mobile>","<apartment>","<stateId>","<cityId>","<country>","<zipCode>","<address>" and "<addressaType>"
    When User send "POST" request for addUserAddress endpoint
    Then User Should Verify the status code is 200
    And User Should verify the addUserAddress response message matches "Address added successfully"

    Examples: 
      | firstName | LastName | mobile     | apartment | stateId | cityId | country | zipCode | address | addressaType |
      | Sowmiya   | C        | 9597903361 | Prince    |     123 |     11 |     101 |   60008 | Chennai | Home         |

  Scenario Outline: Verify updateUserAddress to the application through  api
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body for add new address "<addressid>" "<firstName>","<LastName>","<mobile>","<apartment>","<stateId>","<cityId>","<country>","<zipCode>","<address>" and "<addressaType>"
    When User send "PUT" request for updateUserAddress endpoint
    Then User Should Verify the status code is 200
    And User Should verify the updateUserAddress response message matches "Address updated successfully"

    Examples: 
      | firstName | LastName | mobile     | apartment | stateId | cityId | country | zipCode | address | addressaType | addressId |
      | Sowmiya   | C        | 9597903361 | Prince    |     123 |     11 |     101 |   60008 | Chennai | Home         |     66665 |

  Scenario: Verify getUserAdress to the application through  api
    Given User add header and bearer authorization for accessing address endpoints
    When User send "GET" request for getUserAddress endpoint
    Then User Should Verify the status code is 200
    And User Should verify the getUserAddress response message matches "OK"

  Scenario: Verify deleteUserAdress to the application through  api
    Given User add header and bearer authorization for accessing address endpoints
    When User add request body "<addressid>" for get deleteUseraddress
    When User send "DELETE" request for deleteUserAddress endpoint
    Then User Should Verify the status code is 200
    And User Should verify the deleteUserAddress response message matches "Address deleted successfully"
