Feature: Customer

Background: Below are common steps for every scenario
       Given User Launch Chrome Browser
       When User Opens URL "http://admin-demo.nopcommerce.com/login"
       And User Enters Email as "admin@yourstore.com" and Password as "admin"
       And Click On Login
       Then User can view Dashboard
@sanity
Scenario: Add new Customer
       When User clicks on customer menu 
       And click on customers menu Item
       And click on add new button
       Then user can view add new customer page
       When user enter customer info
       And click on save button
       Then User can view confirmation message "The customer cannot be in both 'Guests' and 'Registered' customer roles"
       And Close Browser
       
@regression       
Scenario: Search Customer by EmailID
    When User clicks on customer menu 
    And click on customers menu Item
    And Enter customer Email
    When Click on search button
    Then User should found Email in the Search table
    And Close Browser       
       
      
