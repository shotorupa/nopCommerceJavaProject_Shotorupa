Feature: Login


@sanity
Scenario: Successful login with valid credentials
        Given User Launch Chrome Browser
        When User Opens URL "http://admin-demo.nopcommerce.com/login"
        And User Enters Email as "admin@yourstore.com" and Password as "admin"
        And Click On Login
        Then Page Title Should be "Dashboard / nopCommerce administration"
        When User Click On Logout link
        Then Page Title Should be "Your store. Login"
        And Close Browser
        
 
 
@regression
Scenario Outline: Login Data Driven
        Given User Launch Chrome Browser
        When User Opens URL "http://admin-demo.nopcommerce.com/login"
        And User Enters Email as "<email>" and Password as "<password>"
        And Click On Login
        Then Page Title Should be "Dashboard / nopCommerce administration"
        When User Click On Logout link
        Then Page Title Should be "Your store. Login"
        And Close Browser
        
     Examples:
     | email  | password |  
     | admin@yourstore.com | admin | 
     | admin@yourstore.com | admin123 | 
  
  
