Feature: Existing_User_TC2

Scenario Outline: Existing user tries to login with invalid credentials
Given Step1: Launch EESL Application on Google Chrome Browser.
When  Step2: The user enters invalid Email/Phonenumber. "<Email>"
And   Step3: The user enters invalid password "<Password>".
Then  Step4: The user clicks on the login button.
And   Step5: An error message "Login was unsuccessful. Please correct the errors and try again." should be displayed.
Then  Step6: The user should remain on the login page.
And   Step7: User left Blank EmailID on Email Textbox as ""
Then  Step8: User left Blank password on password Textbox as ""
And   Step9: User Click the LoginButton unable to reach HomePage and get "This Field is Required" message under the both Textbox.
Then  Step11: User Click the LoginButton unable to reach HomePage and get "This Field is Required" message under the username Textbox.
And   Failure Reporting
 
 
Examples:
|User_Type|Email|Password|
|B2B|Nirmala|Nirmfala@PG1|
|B2B|6556465464|Nirmfala@PG1|
|B2C|Abhijiet| @bdhijietM1|


Scenario Outline: Validate the functionality of the "<User_Type>" Login with Valid Credentials.
		Given Step1: Launch EESL Application on Google Chrome Browser.
    When  Step2: validate User able to reach Login Screen Succesfully.
    Then  Step3: validate User able to pass username on Username TextBox as "<Username>"
    And   Step4: validate User able to pass password on password TextBox as "<Password>".
    Then  Step4: validate User able to click LoginButton.
    And   Step5: validate User able to successfully logged into the EESL ecommerce.
    Then  Failure Reporting
    
Examples:
|User_Type|Username|Password|
|B2B|abishaone@yopmail.com|Qwerty@123|
|B2C|Abhijiet| @bhijietM1|




