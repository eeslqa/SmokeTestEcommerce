@login
Feature: Existing_User_TC2

Scenario: Existing user tries to login with invalid credentials
Given Step1: Launch EESL Application on Google Chrome Browser.
When  Step1.1: The user is able to navigate and verify the login page.
When  Step2: The user enters invalid Email. "eeslqa@gmail.com"
And   Step3: The user enters invalid password "Tangentia@123".
Then  Step4: The user clicks on the login button.
And   Step5: An error message Login was unsuccessful. Please correct the errors and try again should be displayed.
Then  Step6: The user should remain on the login page.
And   Step7: User left Blank EmailID on Email Textbox as " "
Then  Step8: User left Blank password on password Textbox as " "
And   Step9: User Click the LoginButton unable to Login and get This Field is Required message under the both Textbox.
Then  Step11: User Click the LoginButton unable to Login and get This Field is Required message under the both Textbox.
And   Failure Reporting TC2A
 
 Scenario Outline: Validate the functionality of the "<User_Type>" Login with Valid Credentials.
		Given Step1: Launch EESL Application on Google Chrome Browser for TC2B.
    When  Step2: validate User able to reach Login Screen Succesfully.
    Then  Step3: validate User able to pass username on Username TextBox as "<Username>"
    And   Step4: validate User able to pass password on password TextBox as "<Password>".
    Then  Step4: validate User able to click LoginButton.
    And   Step5: validate User able to successfully logged into the EESL ecommerce.
    Then  Failure Reporting TC2B
    
Examples:
|User_Type|Username|Password|
|B2B|abishaone@yopmail.com|Qwerty@123|
|B2C|henrygeorge@yopmail.com|Qwerty@1234|




