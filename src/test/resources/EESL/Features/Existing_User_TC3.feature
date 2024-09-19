@search
Feature: Existing_User_TC3

Scenario Outline: Search the product from the EESL E-Commerce. "<Type>"
    Given Step1: TC3A Launch EESL Application on Google Chrome Browser.
    And Step2: TC3A validate User able to enter search value to the Search_Textbox "<searchdata>".
    Then Step3: TC3A validate User able to click search button.
    And Step4: TC3A validate user navigate to search results page."<Type>"
    Then Step5: TC3A validate the search results should be relavent to the search data "<searchdata>" "<Type>".
    And Step6: TC3A Failure Reporting TC3A 
Examples:
|Type|searchdata|
|Valid_Test_Data|Emergency LED Bulb-10 Watt , 1050 Lumens|
|Valid_Test_Data|1.0 TR Super Efficient 5 Star Split AC|
|Valid_Test_Data|Fan|
|Invalid_Test_Data|amazon basics - 50W LED Bulb, Cool White (Base B22, Pack of 1)|
|Negative| |



 @search1
Scenario Outline: Filter the search results by choosing advanced search option."<Type>"
    Given Step1: TC3B Launch EESL Application on Google Chrome Browser.
    And Step2: TC3B validate User able to enter search value to the Search_Textbox "<searchdata>".
    Then Step3: TC3B validate user able to filter the search results by category and manufacturer."<Category>" "<Manufacturer>"
    And Step4: TC3B validate User able to click search button.
    And Step5: TC3B validate user navigate to search results page.
    Then Step6: TC3B validate the search results should be relevent to the search data and as per the filter added."<searchdata>" "<Category>" "<Manufacturer>" "<Type>"
    And Step7: TC3B Failure Reporting TC3B 
Examples:
|Type|searchdata|Category|Manufacturer|
|Valid_Test_Data|1.0 TR Super Efficient 5 Star Split AC|Cooling >> Air Conditioning|EESL|
|Valid_Test_Data|1200W Induction Cooktop with Slim Body and Premium Quality Features|Electric Cooking >> Induction Cooktop|ALL|
|InValid_TestData|ac|Electric Cooking >> Induction Cooktop|EESL|


