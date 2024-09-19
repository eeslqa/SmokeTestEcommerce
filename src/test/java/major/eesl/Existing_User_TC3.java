package major.eesl;

import java.awt.Color;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pom.eesl.POMExistingUserTC1;
import pom.eesl.POMExistingUserTC2;
import utility.eesl.BaseUtility;

public class Existing_User_TC3 extends BaseUtility {
	POMExistingUserTC1 hp = new POMExistingUserTC1();
	POMExistingUserTC2 eu2 = new POMExistingUserTC2();
	SoftAssert sa = new SoftAssert();
	List<String> failed = new LinkedList<>();

	private Scenario scenario;

	@Before
	public void setUp(Scenario scenario) {
		this.scenario = scenario;
	}

//Search the product from the EESL E-Commerce
	
	@Given("Step1: TC3A Launch EESL Application on Google Chrome Browser.")
	public void step1_tc3a_launch_eesl_application_on_google_chrome_browser() {
		try {
			launchChromeBrowser("https://eeslpreprod.tangentia.com/");
			toMaximize();
			hp = new POMExistingUserTC1();
			
			fwaitpage("EESL India - QA . EESL India - QA");
			
			Thread.sleep(3000);
			generalscreenshotadd(scenario);
			hp.getPopup().click();
			String titleActual = driver.getTitle();
			sa.assertEquals(titleActual, "EESL India - QA . EESL India - QA", "Step1: Launch EESL Application on Google Chrome Browser.");
			boolean Result = titleActual.contains("EESL India - QA . EESL India - QA");
			if (Result) {
				scenario.log("Passed: Successfully navigated to EESL-Ecommerce Homepage");
			} else {
				scenario.log("Failed: Due to page name is not as Expected");
			}
			generalscreenshotadd(scenario);
		} catch (Exception e) {
			
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step1: Launch EESL Application on Google Chrome Browser.");
			generalscreenshotadd(scenario);
		}
	}
	@Given("Step2: TC3A validate User able to enter search value to the Search_Textbox {string}.")
	public void step2_tc3a_validate_user_able_to_enter_search_value_to_the_search_textbox(String string) {
	    try {
	    	hp = new POMExistingUserTC1();
	    	hp.getSearchbar().sendKeys(string);
	    	String attribute = hp.getSearchbar().getAttribute("value");
	    	sa.assertEquals(attribute, string,"Step2: TC3A validate User able to enter search value to the Search_Textbox {string}.");
	    	if (string.equals(attribute)) {
				scenario.log("Passed: User able to enter value to search bar");
			} else {
				scenario.log("Failed: User unable to enter value to search bar");
				failed.add("Step2: TC3A validate User able to enter search value to the Search_Textbox.");
			}
	    	elementscreenshotadd(hp.getSearchbar(), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step2: TC3A validate User able to enter search value to the Search_Textbox.");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step3: TC3A validate User able to click search button.")
	public void step3_tc3a_validate_user_able_to_click_search_button() {
		try {
	    	hp = new POMExistingUserTC1();
	    	hp.getSearchbutton().click();
	    	scenario.log("Passed: User able to click the search Button");
	    	Thread.sleep(1500);
	    	generalscreenshotadd(scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step3: TC3A validate User able to click search button.");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step4: TC3A validate user navigate to search results page.{string}")
	public void step4_tc3a_validate_user_navigate_to_search_results_page(String type) {
		if (type.equals("Negative")) {
			scenario.log("Passed: Successfully navigated to EESL-Ecommerce Search Results page");
		}else {
			try {
				String titleActual = driver.getTitle();
				sa.assertEquals(titleActual, "EESL India - QA . Search", "Step4: TC3A validate user navigate to search results page.");
				boolean Result = titleActual.contains("EESL India - QA . Search");
				if (Result) {
					scenario.log("Passed: Successfully navigated to EESL-Ecommerce Search Results page");
				} else {
					scenario.log("Failed: Due to page name is not as Expected");
					failed.add("Step4: TC3A validate user navigate to search results page.");
				}
				generalscreenshotadd(scenario);
				
			} catch (Exception e) {
				String message = e.getMessage();
				scenario.log("failed due below error: Please contact Automation Test Developer");
				scenario.log("Error message: "+message);
				sa.assertEquals(true, false, "Element not found");
				failed.add("Step4: TC3A validate user navigate to search results page.");
				generalscreenshotadd(scenario);
			}
		}
		
	}
	@Then("Step5: TC3A validate the search results should be relavent to the search data {string} {string}.")
	public void step5_tc3a_validate_the_search_results_should_be_relavent_to_the_search_data(String searchdata, String type) {
	    if (type.equals("Valid_Test_Data")) {
	    	try {
		    	hp = new POMExistingUserTC1();
		    	List<String> searchresults = new LinkedList<>();
		    	int beforecount=0;
		    	for (int i = 0; i < hp.getSearchresults().size(); i++) {
					String text = hp.getSearchresults().get(i).getText();
					searchresults.add(text);
					beforecount++;
				}
		    	int aftercount=0;
		    	for (int i = 0; i < searchresults.size(); i++) {
					boolean contains = searchresults.get(i).contains(searchdata);
					if (contains==true) {
						aftercount++;
					}
					
				}
		    	
		    	sa.assertEquals(beforecount, aftercount,"Step5: TC3A validate the search results should be relavent to the search data {string} {string}.");
		    	if (beforecount==aftercount) {
					scenario.log("Passed: Search results are relavent to the search data");
					scenario.log("The Search Data: "+searchdata);
					for (int i = 0; i < searchresults.size(); i++) {
						scenario.log("The Search Results: "+searchresults.get(i));
					}
				}else {
					scenario.log("Failed: Search results are not relavent to the search data");
					failed.add("Step5: TC3A validate the search results should be relavent to the search data");

				}
		    	Actions ac = new Actions(driver);
		    	ac.scrollToElement(hp.getSearchresults().get(0)).build().perform();
		    	Thread.sleep(1000);
		    	generalscreenshotadd(scenario);
				
			} catch (Exception e) {
				String message = e.getMessage();
				scenario.log("failed due below error: Please contact Automation Test Developer");
				scenario.log("Error message: "+message);
				sa.assertEquals(true, false, "Element not found");
				failed.add("Step5: TC3A validate the search results should be relavent to the search data");
				generalscreenshotadd(scenario);
			}	
		}
	    if (type.equals("Invalid_Test_Data")) {
	    	try {
		    	hp = new POMExistingUserTC1();
		    	boolean displayed = hp.getNosearchresults().isDisplayed();
		    	sa.assertEquals(displayed, true);
		    	if (displayed) {
		    		scenario.log("Passed: No serach results shown for invalid search data");
				}else {
					scenario.log("Failed: serach results are shown for invalid search data");
					failed.add("Invalid_Test_Data Step5: TC3A validate the search results should be relavent to the search data");
				}
		    	elementscreenshotadd(hp.getNosearchresults(), scenario);
		    	
				
			} catch (Exception e) {
				String message = e.getMessage();
				scenario.log("failed due below error: Please contact Automation Test Developer");
				scenario.log("Error message: "+message);
				sa.assertEquals(true, false, "Element not found");
				failed.add("Invalid_Test_Data Step5: TC3A validate the search results should be relavent to the search data");
				generalscreenshotadd(scenario);
			}
	    }
	    	if (type.equals("Negative")) {
		    	try {
			    	hp = new POMExistingUserTC1();
			    	Thread.sleep(750);
			    	fwait(hp.getNegativesearchpopmsg());
			    	boolean displayed = hp.getNegativesearchpopmsg().isDisplayed();
			    	generalscreenshotadd(scenario);
			    	hp.getNegativesearchpopmsgokbtn().click();
			    	sa.assertEquals(displayed, true);
			    	if (displayed) {
			    		scenario.log("Passed: Pop is Shown with warning messeage");
					}else {
						scenario.log("Failed: Pop is not Shown with warning messeage");
						failed.add("Negative Step5: TC3A validate the search results should be relavent to the search data");
					}
			    	
					
				} catch (Exception e) {
					String message = e.getMessage();
					scenario.log("failed due below error: Please contact Automation Test Developer");
					scenario.log("Error message: "+message);
					sa.assertEquals(true, false, "Element not found");
					failed.add("Invalid_Test_Data Step5: TC3A validate the search results should be relavent to the search data");
					generalscreenshotadd(scenario);
				}	
	    	}
	    
		
	}
	@Then("Step6: TC3A Failure Reporting TC3A")
	public void step6_tc3a_failure_reporting_tc3a() {
		boolean empty = failed.isEmpty();
	    if (empty==false) {
	    	scenario.log("The Failed Test Steps are:");
	    	for (String string : failed) {
		    	JTextArea area = new JTextArea(string);
		    	area.setForeground(Color.red);
		    	
		    	scenario.log(string);
			}
		}
		
	    sa.assertAll();
	    String text = "No Failure Found";
	    JTextArea area = new JTextArea(text);
    	area.setForeground(Color.GREEN);
    	scenario.log(text);
	}
	

//Scenario Outline: Filter the search results by choosing advanced search option.
	@Given("Step1: TC3B Launch EESL Application on Google Chrome Browser.")
	public void step1_tc3b_launch_eesl_application_on_google_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Given("Step2: TC3B validate User able to enter search value to the Search_Textbox {string}.")
	public void step2_tc3b_validate_user_able_to_enter_search_value_to_the_search_textbox(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Step3: TC3B validate user able to filter the search results by category and manufacturer.{string} {string}")
	public void step3_tc3b_validate_user_able_to_filter_the_search_results_by_category_and_manufacturer(String category, String manufacturer) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Step4: TC3B validate User able to click search button.")
	public void step4_tc3b_validate_user_able_to_click_search_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Step5: TC3B validate user navigate to search results page.")
	public void step5_tc3b_validate_user_navigate_to_search_results_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Step6: TC3B validate the search results should be relevent to the search data and as per the filter added.{string} {string} {string} {string}")
	public void step6_tc3b_validate_the_search_results_should_be_relevent_to_the_search_data_and_as_per_the_filter_added(String searchdata, String category, String manufacturer, String type) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("Step7: TC3B Failure Reporting TC3B")
	public void step7_tc3b_failure_reporting_tc3b() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	

}
