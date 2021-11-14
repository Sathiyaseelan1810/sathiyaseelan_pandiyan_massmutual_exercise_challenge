Feature: Verify the provided values based on the Objectives

  Scenario: Validate the Values based on Objective
    Given Launch the Chrome Browser sucessfully
    And Navigate to the URL
    When Fetch the label and values from the mock webpage and verify the counts
    And Verify the each values displayed on the screen are greater than Zero
    And Compare the total balance shown on the screen
    And Verify the Values are formatted as currencies
    Then Sum the values and validate against the total balance
    And Close the Browser

    
# ----- Objectives -----
#Need to verify the right count of values appear on the screen
#Need to verify the values on the screen are greater than 0
#Need to verify the total balance is correct based on the values listed on the screen
#Need to verify the values are formatted as currencies
#Need to verify the total balance matches the sum of the values
#Create a mockup of what the results would look like assuming all steps passed
#Knowns:
#ID’s of the objects are blue and needs to support Chrome
#URL to this page is https://www.exercise1.com/values (mock / not real / just for coding purposes)