
Feature: To test Create Flag functionality
  
  Scenario: To check whether the flag is created or not
    Given user is on create flag page
    When user enters company name   
    And Po number
    And Department
    And notes
    And followup Date
    And order Id
    And flag
    And AssignedTo
    And click on submit
    Then Flag is created 
    And is visible in the View All Flags list
    
 
 
