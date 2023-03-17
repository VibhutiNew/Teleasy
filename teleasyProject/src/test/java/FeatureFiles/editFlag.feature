Feature: To test edit flag functionality
  
  
  Scenario: To check whether the flag is edited or not
    Given user is on flag list page
    When user clicks on the flag
    And add the comments
    And update the status
    And clicks on update
    Then flag is edited
    And visible in the View All Flags list