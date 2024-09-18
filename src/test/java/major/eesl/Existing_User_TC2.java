package major.eesl;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
import io.cucumber.java.en.When;
import pom.eesl.POMExistingUserTC1;
import pom.eesl.POMExistingUserTC2;
import utility.eesl.BaseUtility;

public class Existing_User_TC2 extends BaseUtility {
	POMExistingUserTC1 hp = new POMExistingUserTC1();
	POMExistingUserTC2 eu2 = new POMExistingUserTC2();
	SoftAssert sa = new SoftAssert();
	List<String> failed = new LinkedList<>();

	private Scenario scenario;

	@Before
	public void setUp(Scenario scenario) {
		this.scenario = scenario;
	}

//Existing user tries to login with invalid credentials
	
	@Given("Step1: Launch EESL Application on Google Chrome Browser.")
	public void step1_launch_eesl_application_on_google_chrome_browser() {
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
	@When("Step1.1: The user is able to navigate and verify the login page.")
	public void step2_the_user_is_able_to_navigate_and_verify_the_login_page() {
	   try {
	    	 eu2= new POMExistingUserTC2();
	    	 Actions ac = new Actions(driver);
	    	 ac.moveToElement(eu2.getSignupLoginicon()).build().perform();
	    	 eu2.getLogin().click();
	    	 Thread.sleep(2000);
	    	 fwait(eu2.getWelcomemsg());
	    	 boolean displayed = eu2.getWelcomemsg().isDisplayed();
	    	 sa.assertEquals(displayed, true);
	    	 if (displayed==true) {
				scenario.log("Passed: Successfully navigated to the Login Page");
				scenario.log("Passed: Welcome messeage is present on the homepage.");
				generalscreenshotadd(scenario);
			}
	    	 
	    	 else {
	    		 scenario.log("Failed: Failed to navigate to the Login Page");
				 scenario.log("Failed: Welcome messeage is not present on the homepage.");
				 failed.add("Step1.1: The user is able to navigate and verify the login page.");
				 generalscreenshotadd(scenario);
			}
	    	 
	    	 
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step1.1: The user is able to navigate and verify the login page.");
			generalscreenshotadd(scenario);
		}
	}
	@When("Step2: The user enters invalid Email. {string}")
	public void step2_the_user_enters_invalid_email(String string) {
	   try {
		   eu2= new POMExistingUserTC2();
		   eu2.getEmailtextbox().sendKeys(string);
		   elementscreenshotadd(eu2.getEmailtextbox(), scenario);
		
	} catch (Exception e) {
		String message = e.getMessage();
		scenario.log("failed due below error: Please contact Automation Test Developer");
		scenario.log("Error message: "+message);
		sa.assertEquals(true, false, "Element not found");
		failed.add("Step2: The user enters invalid Email.");
		generalscreenshotadd(scenario);
	}
	}
	@When("Step3: The user enters invalid password {string}.")
	public void step3_the_user_enters_invalid_password(String string) {
		try {
			   eu2= new POMExistingUserTC2();
			   eu2.getPasstextbox().sendKeys(string);
			   elementscreenshotadd(eu2.getPasstextbox(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step3: The user enters invalid password.");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step4: The user clicks on the login button.")
	public void step4_the_user_clicks_on_the_login_button() {
		try {
			   eu2= new POMExistingUserTC2();
			   eu2.getLoginButton().click();
			   generalscreenshotadd(scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step4: The user clicks on the login button.");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step5: An error message Login was unsuccessful. Please correct the errors and try again should be displayed.")
	public void step5_an_error_message_login_was_unsuccessful_please_correct_the_errors_and_try_again_should_be_displayed() {
		try {
			   eu2= new POMExistingUserTC2();
			   boolean displayed = eu2.getInvaliderrormsg().isDisplayed();
			   if (displayed) {
				scenario.log("Passed: Invalid Credential msg displayed");
			}
			   elementscreenshotadd(eu2.getInvaliderrormsg(), scenario);
			   eu2.getEmailtextbox().clear();
			   eu2.getPasstextbox().clear();
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step5: An error message Login was unsuccessful. Please correct the errors and try again should be displayed.");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step6: The user should remain on the login page.")
	public void step6_the_user_should_remain_on_the_login_page() {
	  try {
		    	 eu2= new POMExistingUserTC2();
		    	fwait(eu2.getWelcomemsg());
		    	 boolean displayed = eu2.getWelcomemsg().isDisplayed();
		    	 sa.assertEquals(displayed, true);
		    	 generalscreenshotadd(scenario);
	} catch (Exception e) {
		String message = e.getMessage();
		scenario.log("failed due below error: Please contact Automation Test Developer");
		scenario.log("Error message: "+message);
		sa.assertEquals(true, false, "Element not found");
		failed.add("Step6: The user should remain on the login page.");
		generalscreenshotadd(scenario);
	}
	}
	@Then("Step7: User left Blank EmailID on Email Textbox as {string}")
	public void step7_user_left_blank_email_id_on_email_textbox_as(String string) {
		try {
			   eu2= new POMExistingUserTC2();
			   eu2.getEmailtextbox().sendKeys(string);
			   elementscreenshotadd(eu2.getEmailtextbox(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step7: User left Blank EmailID on Email Textbox");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step8: User left Blank password on password Textbox as {string}")
	public void step8_user_left_blank_password_on_password_textbox_as(String string) {
		try {
			   eu2= new POMExistingUserTC2();
			   eu2.getPasstextbox().sendKeys(string);
			   elementscreenshotadd(eu2.getPasstextbox(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step8: User left Blank password on password Textbox");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step9: User Click the LoginButton unable to Login and get This Field is Required message under the both Textbox.")
	public void step9_user_click_the_login_button_unable_to_reach_home_page_and_get_this_field_is_required_message_under_the_both_textbox() {
		try {   
		eu2= new POMExistingUserTC2();
		   eu2.getLoginButton().click();
		   generalscreenshotadd(scenario);
		
	} catch (Exception e) {
		String message = e.getMessage();
		scenario.log("failed due below error: Please contact Automation Test Developer");
		scenario.log("Error message: "+message);
		sa.assertEquals(true, false, "Element not found");
		failed.add("Step9: User Click the LoginButton unable to Login and get This Field is Required message under the both Textbox.");
		generalscreenshotadd(scenario);
	}
	}
	@Then("Step11: User Click the LoginButton unable to Login and get This Field is Required message under the both Textbox.")
	public void step11_user_click_the_login_button_unable_to_reach_home_page_and_get_this_field_is_required_message_under_the_username_textbox() {
		try {   
			eu2= new POMExistingUserTC2();
			scenario.log("This Field is Required message is not shown");
			   assertTrue(false, "This Field is Required message is not shown");
			   generalscreenshotadd(scenario);
			
		} catch (AssertionError | Exception e1) {
			String message = e1.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step11: User Click the LoginButton unable to Login and get This Field is Required message under the both Textbox.");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Failure Reporting TC2A")
	public void failure_reporting_tc2_a() {
		boolean empty = failed.isEmpty();
		scenario.log("The Failed Test Steps are:");
		if (empty==false) {
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

//Validate the functionality of the "<User_Type>" Login with Valid Credentials.
	SoftAssert sa1 = new SoftAssert();
	List<String> failed1 = new LinkedList<>();
	@Given("Step1: Launch EESL Application on Google Chrome Browser for TC2B.")
	public void step1_launch_eesl_application_on_google_chrome_browser_for_tc2b() {
		try {
			launchChromeBrowser("https://eeslpreprod.tangentia.com/");
			toMaximize();
			hp = new POMExistingUserTC1();
			
			fwaitpage("EESL India - QA . EESL India - QA");
			
			Thread.sleep(3000);
			generalscreenshotadd(scenario);
			hp.getPopup().click();
			String titleActual = driver.getTitle();
			sa1.assertEquals(titleActual, "EESL India - QA . EESL India - QA", "Step1: Launch EESL Application on Google Chrome Browser.");
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
			sa1.assertEquals(true, false, "Element not found");
			failed1.add("Step1: Launch EESL Application on Google Chrome Browser for TC2B.");
			generalscreenshotadd(scenario);
		}
	}
	@When("Step2: validate User able to reach Login Screen Succesfully.")
	public void step2_validate_user_able_to_reach_login_screen_succesfully() {
		try {
	    	 eu2= new POMExistingUserTC2();
	    	 Actions ac = new Actions(driver);
	    	 ac.moveToElement(eu2.getSignupLoginicon()).build().perform();
	    	 eu2.getLogin().click();
	    	 Thread.sleep(2000);
	    	 fwait(eu2.getWelcomemsg());
	    	 boolean displayed = eu2.getWelcomemsg().isDisplayed();
	    	 sa1.assertEquals(displayed, true);
	    	 if (displayed==true) {
				scenario.log("Passed: Successfully navigated to the Login Page");
				scenario.log("Passed: Welcome messeage is present on the homepage.");
				generalscreenshotadd(scenario);
			}
	    	 
	    	 else {
	    		 scenario.log("Failed: Failed to navigate to the Login Page");
				 scenario.log("Failed: Welcome messeage is not present on the homepage.");
				 failed.add("Step2: validate User able to reach Login Screen Succesfully.");
				 generalscreenshotadd(scenario);
			}
	    	 
	    	 
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa1.assertEquals(true, false, "Element not found");
			failed1.add("Step2: validate User able to reach Login Screen Succesfully.");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step3: validate User able to pass username on Username TextBox as {string}")
	public void step3_validate_user_able_to_pass_username_on_username_text_box_as(String string) {
		try {
			   eu2= new POMExistingUserTC2();
			   eu2.getEmailtextbox().sendKeys(string);
			   elementscreenshotadd(eu2.getEmailtextbox(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa1.assertEquals(true, false, "Element not found");
			failed1.add("Step3: validate User able to pass username on Username TextBox");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step4: validate User able to pass password on password TextBox as {string}.")
	public void step4_validate_user_able_to_pass_password_on_password_text_box_as(String string) {
		try {
			   eu2= new POMExistingUserTC2();
			   eu2.getPasstextbox().sendKeys(string);
			   elementscreenshotadd(eu2.getPasstextbox(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa1.assertEquals(true, false, "Element not found");
			failed1.add("Step4: validate User able to pass password on password TextBox as {string}");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step5: validate User able to click LoginButton.")
	public void step4_validate_user_able_to_click_login_button() {
		try {   
			eu2= new POMExistingUserTC2();
			   eu2.getLoginButton().click();
			   generalscreenshotadd(scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa1.assertEquals(true, false, "Element not found");
			failed1.add("Step5: validate User able to click LoginButton.");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Step6: validate User able to successfully logged into the EESL ecommerce.")
	public void step5_validate_user_able_to_successfully_logged_into_the_eesl_ecommerce() {
		try {   
			eu2= new POMExistingUserTC2();
			 Actions ac = new Actions(driver);
			 ac.moveToElement(eu2.getLoginaccount()).build().perform();
			 eu2.getMyaccount().click();
			 Thread.sleep(3000);
			 fwait(eu2.getCustomerinfolabel());
			 boolean displayed = eu2.getCustomerinfolabel().isDisplayed();
			 if (displayed) {
				 try {
					eu2.getBussinessprofiles().click();
					Thread.sleep(2000);
					boolean displayed2 = eu2.getGstnumber().isDisplayed();
					sa1.assertEquals(displayed, true,"Element not found");
					if (displayed2) {
						scenario.log("Passed: User successfuly logged into the B2B account");
					}
				} catch (Exception e) {
					scenario.log("Passed: User successfuly logged into the B2C account");
				}
				
			}else {
				scenario.log("failed: User unable to log into the account");
				sa1.assertEquals(false, true,"Element not found");
				failed1.add("Step6: validate User able to successfully logged into the EESL ecommerce.");
			}
			 generalscreenshotadd(scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa1.assertEquals(true, false, "Element not found");
			failed1.add("Step6: validate User able to successfully logged into the EESL ecommerce.");
			generalscreenshotadd(scenario);
		}
		
	}
	@Then("Step7: validate User able to successfully logged out from the EESL ecommerce.")
	public void step7_validate_user_able_to_successfully_logged_out_from_the_eesl_ecommerce() {
	    try {
	    	eu2= new POMExistingUserTC2();
	    	 Actions ac = new Actions(driver);
			 ac.moveToElement(eu2.getLoginaccount()).build().perform();
			 eu2.getLogout().click();
			 Thread.sleep(3000);
			 ac.moveToElement(eu2.getSignupLoginicon()).build().perform();
			 boolean displayed = eu2.getLogin().isDisplayed();
			 sa1.assertEquals(displayed, true,"Element not found");
			 if (displayed) {
				 scenario.log("Passed: User successfuly logged out from the account");
			}else {
				scenario.log("Passed: User unable to logged out from the account");
				failed1.add("Step7: validate User able to successfully logged out from the EESL ecommerce.");
				sa1.assertEquals(true, false,"Element not found");
			}
			 Thread.sleep(1500);
			 elementscreenshotadd(eu2.getLogin(), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa1.assertEquals(true, false, "Element not found");
			failed1.add("Step7: validate User able to successfully logged out from the EESL ecommerce.");
			generalscreenshotadd(scenario);
		}
	}
	@Then("Failure Reporting TC2B")
	public void failure_reporting_tc2b() {
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
}
