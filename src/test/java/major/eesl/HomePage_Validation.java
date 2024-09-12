package major.eesl;

import java.awt.Color;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.eesl.HomePageElements;
import utility.eesl.BaseUtility;

public class HomePage_Validation extends BaseUtility {
	HomePageElements hp = new HomePageElements();
	SoftAssert sa = new SoftAssert();
	List<String> failed = new LinkedList<>();

	private Scenario scenario;

	@Before
	public void setUp(Scenario scenario) {
		this.scenario = scenario;
	}

	@Given("Step1: Launch EESL web application via Google chrome web browser.")
	public void step1_launch_eesl_web_application_via_google_chrome_web_browser() throws IOException {
		
		try {
			launchChromeBrowser("https://eeslpreprod.tangentia.com/");
			toMaximize();
			hp = new HomePageElements();
			
			fwaitpage("EESL India - QA . EESL India - QA");
			
			Thread.sleep(3000);
			generalscreenshotadd(scenario);
			hp.getPopup().click();
			String titleActual = driver.getTitle();
			sa.assertEquals(titleActual, "EESL India - QA . EESL India - QA", "Page title validation");
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
			failed.add("Step1: Launch EESL web application via Google chrome web browser.");
			generalscreenshotadd(scenario);
		}

	}

	@Given("Step2: To check whether EESL Logo is present on the homepage.")
	public void step2_to_check_whether_eesl_logo_is_present_on_the_homepage() throws IOException {
		
		try {
			hp = new HomePageElements();
			
			boolean result = hp.getEeslLogo().isDisplayed();
			sa.assertEquals(result, true,"EESL Logo Validation");
			if (result) {
				scenario.log("Passed: EESL Logo is present on the homepage.");
			} else {
				scenario.log("Failed: EESL Logo is not present on the homepage.");
			}
			elementscreenshotadd(hp.getEeslLogo(), scenario);
		} catch (Exception e) {
			
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step2: To check whether EESL Logo is present on the homepage.");
			generalscreenshotadd(scenario);
		}

	}

	@When("Step3: To check whether Beta Label is present on the homepage.")
	public void step3_to_check_whether_beta_label_is_present_on_the_homepage() throws IOException {

		
		try {
			hp = new HomePageElements();
			
			boolean result = hp.getBetaLabel().isDisplayed();
			sa.assertEquals(result, true,"Step3: To check whether Beta Label is present on the homepage.");
			if (result) {
				scenario.log("Passed: BetaLabel is present on the homepage.");
			} else {
				scenario.log("Failed: BetaLabel is not present on the homepage.");
			}
			elementscreenshotadd(hp.getBetaLabel(), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step3: To check whether Beta Label is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step4: To check whether Search bar is present on the homepage.")
	public void step4_to_check_whether_search_bar_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getSearchbar().isDisplayed();
			boolean result1 = hp.getSearchbutton().isDisplayed();
			sa.assertEquals(result, true,"Step4: To check whether Search bar is present on the homepage.");
			if (result) {
				scenario.log("Passed: Search_TexBox is present on the homepage.");
			} else {
				scenario.log("Failed: Search_TexBox is not present on the homepage.");
			}
			if (result1) {
				scenario.log("Passed: Search_Submit_Icon is present on the homepage.");
			} else {
				scenario.log("Failed: Search_Submit_Icon is not present on the homepage.");
			}
			elementscreenshotadd(hp.getSearchbar(), scenario);
			elementscreenshotadd(hp.getSearchbutton(), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step4: To check whether Search bar is present on the homepage.");
			generalscreenshotadd(scenario);
			
		}
	}

	@Then("Step5: To check whether User Icon is present on the homepage.")
	public void step5_to_check_whether_user_icon_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getSignupLoginicon().isDisplayed();
			boolean result1 = hp.getSignuploginLabel().isDisplayed();
			sa.assertEquals(result, true,"Step5: To check whether User Icon is present on the homepage.");
			if (result) {
				scenario.log("Passed: User_Account_Icon is present on the homepage.");
			} else {
				scenario.log("Failed: User_Account_Icon is not present on the homepage.");
			}
			if (result1) {
				scenario.log("Passed: Signup_Login_Label is present on the homepage.");
			} else {
				scenario.log("Failed: Signup_Login_Label is not present on the homepage.");
			}
			elementscreenshotadd(hp.getSignupLoginicon(), scenario);
			elementscreenshotadd(hp.getSignuploginLabel(), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step5: To check whether User Icon is present on the homepage.");
			generalscreenshotadd(scenario);
			
		}
	}

	@Then("Step6: To check whether Language dropdown is present on the homepage.")
	public void step6_to_check_whether_language_dropdown_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getLanguagedropdown().isDisplayed();
			
			sa.assertEquals(result, true,"Step6: To check whether Language dropdown is present on the homepage.");
			if (result) {
				scenario.log("Passed: Language_Dropdown is present on the homepage.");
			} else {
				scenario.log("Failed: Language_Dropdown is not present on the homepage.");
			}
			elementscreenshotadd(hp.getLanguagedropdown(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step6: To check whether Language dropdown is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step7: To check whether Wishlist icon is present on the homepage.")
	public void step7_to_check_whether_wishlist_icon_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getWishlisticon().isDisplayed();
			
			sa.assertEquals(result, true,"Step7: To check whether Wishlist icon is present on the homepage.");
			if (result) {
				scenario.log("Passed: WishList_Icon is present on the homepage.");
			} else {
				scenario.log("Failed: WishList_Icon is not present on the homepage.");
			}
			elementscreenshotadd(hp.getWishlisticon(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step7: To check whether Wishlist icon is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step8: To check whether Cart icon is present on the homepage.")
	public void step8_to_check_whether_cart_icon_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getCarticon().isDisplayed();

			sa.assertEquals(result, true,"Step8: To check whether Cart icon is present on the homepage.");
			if (result) {
				scenario.log("Passed: Cart_Icon is present on the homepage.");
			} else {
				scenario.log("Failed: Cart_Icon is not present on the homepage.");
			}
			elementscreenshotadd(hp.getCarticon(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step8: To check whether Cart icon is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step9: To check whether Electric Cooking menu is present on the homepage.")
	public void step9_to_check_whether_electric_cooking_menu_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getElectricCookingmenu().isDisplayed();
			
			sa.assertEquals(result, true,"Step9: To check whether Electric Cooking menu is present on the homepage.");
			if (result) {
				scenario.log("Passed: ElectricCooking_Menu is present on the homepage.");
			} else {
				scenario.log("Failed: ElectricCooking_Menu is not present on the homepage.");
			}
			elementscreenshotadd(hp.getElectricCookingmenu(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step9: To check whether Electric Cooking menu is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step10: To check whether Lighting menu is present on the homepage.")
	public void step10_to_check_whether_lighting_menu_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getLightingmenu().isDisplayed();
			
			sa.assertEquals(result, true,"Step10: To check whether Lighting menu is present on the homepage.");
			if (result) {
				scenario.log("Passed: Lightning_Menu is present on the homepage.");
			} else {
				scenario.log("Failed: Lightning_Menu is not present on the homepage.");
			}
			elementscreenshotadd(hp.getLightingmenu(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step10: To check whether Lighting menu is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step11: To check whether Cooling menu is present on the homepage.")
	public void step11_to_check_whether_cooling_menu_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getCoolingmenu().isDisplayed();
			
			sa.assertEquals(result, true,"Step11: To check whether Cooling menu is present on the homepage.");
			if (result) {
				scenario.log("Passed: Cooling_Menu is present on the homepage.");
			} else {
				scenario.log("Failed: Cooling_Menu is not present on the homepage.");
			}
			elementscreenshotadd(hp.getCoolingmenu(), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step11: To check whether Cooling menu is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step12: To check whether URJAVEER menu is present on the homepage.")
	public void step12_to_check_whether_urjaveer_menu_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getUrjaveermenu().isDisplayed();
			
			sa.assertEquals(result, true,"Step12: To check whether URJAVEER menu is present on the homepage.");
			if (result) {
				scenario.log("Passed: URJAVEER_Menu is present on the homepage.");
			} else {
				scenario.log("Failed: URJAVEER_Menu is not present on the homepage.");
			}
			elementscreenshotadd(hp.getUrjaveermenu(), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step12: To check whether URJAVEER menu is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step13: To check whether Know More menu is present on the homepage.")
	public void step13_to_check_whether_know_more_menu_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getKnowmoremenu().isDisplayed();
			
			sa.assertEquals(result, true,"Step13: To check whether Know More menu is present on the homepage.");
			if (result) {
				scenario.log("Passed: KnowMore_Menu is present on the homepage.");
			} else {
				scenario.log("Failed: KnowMore_Menu is not present on the homepage.");
			}elementscreenshotadd(hp.getKnowmoremenu(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step13: To check whether Know More menu is present on the homepage.");
			generalscreenshotadd(scenario);
		} 
	}

	@Then("Step14: To check whether About Us menu is present on the homepage.")
	public void step14_to_check_whether_about_us_menu_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getAboutUs().isDisplayed();
			
			sa.assertEquals(result, true,"Step14: To check whether About Us menu is present on the homepage.");
			if (result) {
				scenario.log("Passed: AboutUs_Menu is present on the homepage.");
			} else {
				scenario.log("Failed: AboutUs_Menu is not present on the homepage.");
			}elementscreenshotadd(hp.getAboutUs(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step14: To check whether About Us menu is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step15: To check whether Shopping by Category section label is present on the homepage.")
	public void step15_to_check_whether_shopping_by_category_section_label_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getShopbycategorylabel().isDisplayed();
			
			sa.assertEquals(result, true,"Step15: To check whether Shopping by Category section label is present on the homepage.");
			if (result) {
				scenario.log("Passed: Shopping by Category section label is present on the homepage.");
			} else {
				scenario.log("Failed: Shopping by Category section label is not present on the homepage.");
			}elementscreenshotadd(hp.getShopbycategorylabel(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step15: To check whether Shopping by Category section label is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step16: To check whether Shopping by Category section navigation buttons is present on the homepage.")
	public void step16_to_check_whether_shopping_by_category_section_navigation_buttons_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();\
			
			int size = hp.getProductnavigationbutton().size();
			
			
			sa.assertEquals(size, 4,"Step16: To check whether Shopping by Category section navigation buttons is present on the homepage.");
			if (size==4) {
				scenario.log("Passed: Shopping by Category section navigation buttons are present on the homepage.");
			} else {
				scenario.log("Failed: Shopping by Category section navigation buttons are not present on the homepage.");
			}
			//elementscreenshotadd(hp.getProductnavigationbutton().get(0), scenario);
			//elementscreenshotadd(hp.getProductnavigationbutton().get(1), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step16: To check whether Shopping by Category section navigation buttons is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step17: To check whether Featured products section label is present on the homepage.")
	public void step17_to_check_whether_featured_products_section_label_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getFeaturedproductlabel().isDisplayed();
			
			sa.assertEquals(result, true,"Step17: To check whether Featured products section label is present on the homepage.");
			if (result) {
				scenario.log("Passed: Featured products section label is present on the homepage.");
			} else {
				scenario.log("Failed: Featured products section label is not present on the homepage.");
			}elementscreenshotadd(hp.getFeaturedproductlabel(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step17: To check whether Featured products section label is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step18: To check whether Featured products section navigation buttons is present on the homepage.")
	public void step18_to_check_whether_featured_products_section_navigation_buttons_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			int size = hp.getProductnavigationbutton().size();
			
			
			sa.assertEquals(size, 4,"Step18: To check whether Featured products section navigation buttons is present on the homepage.");
			if (size==4) {
				scenario.log("Passed: Featured products section navigation buttons are present on the homepage.");
			} else {
				scenario.log("Failed: Featured products section navigation buttons are not present on the homepage.");
			}elementscreenshotadd(hp.getProductnavigationbutton().get(2), scenario);
			elementscreenshotadd(hp.getProductnavigationbutton().get(3), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step18: To check whether Featured products section navigation buttons is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step19: To check whether Refund policy link is present on the homepage.")
	public void step19_to_check_whether_refund_policy_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getRefundPolicy().isDisplayed();
			
			sa.assertEquals(result, true,"Step19: To check whether Refund policy link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Refund policy link is present on the homepage.");
			} else {
				scenario.log("Failed: Refund policy link is not present on the homepage.");
			}elementscreenshotadd(hp.getRefundPolicy(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step19: To check whether Refund policy link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step20: To check whether Order Cancellation Policy link is present on the homepage.")
	public void step20_to_check_whether_order_cancellation_policy_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getOrderCancellation().isDisplayed();
			
			sa.assertEquals(result, true,"Step20: To check whether Order Cancellation Policy link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Order Cancellation Policy lin is present on the homepage.");
			} else {
				scenario.log("Failed: Order Cancellation Policy lin is not present on the homepage.");
			}elementscreenshotadd(hp.getOrderCancellation(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step20: To check whether Order Cancellation Policy link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step21: To check whether Replacement & Return Policy link is present on the homepage.")
	public void step21_to_check_whether_replacement_return_policy_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getReplacementReturnPolicylink().isDisplayed();
			
			sa.assertEquals(result, true,"Step21: To check whether Replacement & Return Policy link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Replacement & Return Policy link is present on the homepage.");
			} else {
				scenario.log("Failed: Replacement & Return Policy link is not present on the homepage.");
			}
			elementscreenshotadd(hp.getReplacementReturnPolicylink(), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step21: To check whether Replacement & Return Policy link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step22: To check whether Warranty Policy link is present on the homepage.")
	public void step22_to_check_whether_warranty_policy_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getWarrantyPolicylink().isDisplayed();
			
			sa.assertEquals(result, true,"Step22: To check whether Warranty Policy link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Warranty Policy link is present on the homepage.");
			} else {
				scenario.log("Failed: Warranty Policy link is not present on the homepage.");
			}elementscreenshotadd(hp.getWarrantyPolicylink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step22: To check whether Warranty Policy link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step23: To check whether FAQ link is present on the homepage.")
	public void step23_to_check_whether_faq_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getFaqlink().isDisplayed();
			
			sa.assertEquals(result, true,"Step23: To check whether FAQ link is present on the homepage.");
			if (result) {
				scenario.log("Passed: FAQ link is present on the homepage.");
			} else {
				scenario.log("Failed: FAQ link is not present on the homepage.");
			}elementscreenshotadd(hp.getFaqlink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step23: To check whether FAQ link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step24: To check whether Shipping & returns link is present on the homepage.")
	public void step24_to_check_whether_shipping_returns_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getShippingLink().isDisplayed();
			
			sa.assertEquals(result, true,"Step24: To check whether Shipping & returns link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Shipping & returns link is present on the homepage.");
			} else {
				scenario.log("Failed: Shipping & returns link is present on the homepage.");
			}elementscreenshotadd(hp.getShippingLink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step24: To check whether Shipping & returns link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step25: To check whether Privacy notice link is present on the homepage.")
	public void step25_to_check_whether_privacy_notice_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getPrivacyLink().isDisplayed();
			
			sa.assertEquals(result, true,"Step25: To check whether Privacy notice link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Privacy notice link is present on the homepage.");
			} else {
				scenario.log("Failed: Privacy notice link is present on the homepage.");
			}elementscreenshotadd(hp.getPrivacyLink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step25: To check whether Privacy notice link is present on the homepage.");
			generalscreenshotadd(scenario);
			
		}
		
	}

	@Then("Step26: To check whether Conditions of Use link is present on the homepage.")
	public void step26_to_check_whether_conditions_of_use_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getConditionsLink().isDisplayed();
			
			sa.assertEquals(result, true,"Step26: To check whether Conditions of Use link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Conditions of Use link is present on the homepage.");
			} else {
				scenario.log("Failed: Conditions of Use link is present on the homepage.");
			}elementscreenshotadd(hp.getConditionsLink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step26: To check whether Conditions of Use link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step27: To check whether About Us link is present on the homepage.")
	public void step27_to_check_whether_about_us_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getAboutLink().isDisplayed();
			
			sa.assertEquals(result, true,"Step27: To check whether About Us link is present on the homepage.");
			if (result) {
				scenario.log("Passed: About Us link is present on the homepage.");
			} else {
				scenario.log("Failed: About Us link is present on the homepage.");
			}
			elementscreenshotadd(hp.getAboutLink(), scenario);
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step27: To check whether About Us link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step28: To check whether Contact us link is present on the homepage.")
	public void step28_to_check_whether_contact_us_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getContactusLink().isDisplayed();
			
			sa.assertEquals(result, true,"Step28: To check whether Contact us link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Contact us link is present on the homepage.");
			} else {
				scenario.log("Failed: Contact us link is present on the homepage.");
			}elementscreenshotadd(hp.getContactusLink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step28: To check whether Contact us link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step29: To check whether Search link is present on the homepage.")
	public void step29_to_check_whether_search_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getSearchlink().isDisplayed();
			
			sa.assertEquals(result, true,"Step29: To check whether Search link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Search link is present on the homepage.");
			} else {
				scenario.log("Failed: Search link is not present on the homepage.");
			}elementscreenshotadd(hp.getSearchlink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step29: To check whether Search link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step30: To check whether Recently viewed products link is present on the homepage.")
	public void step30_to_check_whether_recently_viewed_products_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getRecentlyviewedproductslink().isDisplayed();
			
			sa.assertEquals(result, true,"Step30: To check whether Recently viewed products link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Recently viewed products is present on the homepage.");
			} else {
				scenario.log("Failed: Recently viewed products is not present on the homepage.");
			}elementscreenshotadd(hp.getRecentlyviewedproductslink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step30: To check whether Recently viewed products link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step31: To check whether Compare products list link is present on the homepage.")
	public void step31_to_check_whether_compare_products_list_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getCompareproductslistlink().isDisplayed();
			
			sa.assertEquals(result, true,"Step31: To check whether Compare products list link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Compare products list link is present on the homepage.");
			} else {
				scenario.log("Failed: Compare products list link is not present on the homepage.");
			}elementscreenshotadd(hp.getCompareproductslistlink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step31: To check whether Compare products list link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step32: To check whether Coming Soon link is present on the homepage.")
	public void step32_to_check_whether_coming_soon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getComingSoonlink().isDisplayed();
			
			sa.assertEquals(result, true,"Step32: To check whether Coming Soon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Coming Soon link is present on the homepage.");
			} else {
				scenario.log("Failed: Coming Soon link is not present on the homepage.");
			}elementscreenshotadd(hp.getComingSoonlink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step32: To check whether Coming Soon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step33: To check whether My account link is present on the homepage.")
	public void step33_to_check_whether_my_account_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getMyaccountlink().isDisplayed();
			
			sa.assertEquals(result, true,"Step33: To check whether My account link is present on the homepage.");
			if (result) {
				scenario.log("Passed: My account link is present on the homepage.");
			} else {
				scenario.log("Failed: My account link is not present on the homepage.");
			}elementscreenshotadd(hp.getMyaccountlink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step33: To check whether My account link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step34: To check whether Orders link is present on the homepage.")
	public void step34_to_check_whether_orders_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getOrderslink().isDisplayed();
		
			sa.assertEquals(result, true,"Step34: To check whether Orders link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Orders link is present on the homepage.");
			} else {
				scenario.log("Failed: Orders link is not present on the homepage.");
			}elementscreenshotadd(hp.getOrderslink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step34: To check whether Orders link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step35: To check whether Shopping cart link is present on the homepage.")
	public void step35_to_check_whether_shopping_cart_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getShoppingcartlink().isDisplayed();
			
			sa.assertEquals(result, true,"Step35: To check whether Shopping cart link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Shopping cart link is present on the homepage.");
			} else {
				scenario.log("Failed: Shopping cart link is not present on the homepage.");
			}elementscreenshotadd(hp.getShoppingcartlink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step35: To check whether Shopping cart link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step36: To check whether Wishlist link is present on the homepage.")
	public void step36_to_check_whether_wishlist_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getWishlistlink().isDisplayed();
			
			sa.assertEquals(result, true,"Step36: To check whether Wishlist link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Wishlist is present on the homepage.");
			} else {
				scenario.log("Failed: Wishlist is not present on the homepage.");
			}elementscreenshotadd(hp.getWishlistlink(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step36: To check whether Wishlist link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step37: To check whether Make in India icon link is present on the homepage.")
	public void step37_to_check_whether_make_in_india_icon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getMakeinindia().isDisplayed();
			
			sa.assertEquals(result, true,"Step37: To check whether Make in India icon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Make in India icon link is present on the homepage.");
			} else {
				scenario.log("Failed: Make in India icon link is not present on the homepage.");
			}elementscreenshotadd(hp.getMakeinindia(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step37: To check whether Make in India icon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step38: To check whether Swachhbharat icon link is present on the homepage.")
	public void step38_to_check_whether_swachhbharat_icon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getSwatchbharat().isDisplayed();
			
			sa.assertEquals(result, true,"Step38: To check whether Swachhbharat icon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Swachhbharat icon link is present on the homepage.");
			} else {
				scenario.log("Failed: Swachhbharat icon link is not present on the homepage.");
			}elementscreenshotadd(hp.getSwatchbharat(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step38: To check whether Swachhbharat icon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step39: To check whether MyGov icon link is present on the homepage.")
	public void step39_to_check_whether_my_gov_icon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getMygov().isDisplayed();
			
			sa.assertEquals(result, true,"Step39: To check whether MyGov icon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: MyGov icon link is present on the homepage.");
			} else {
				scenario.log("Failed: MyGov icon link is not present on the homepage.");
			}elementscreenshotadd(hp.getMygov(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step39: To check whether MyGov icon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step40: To check whether samanvay icon link is present on the homepage.")
	public void step40_to_check_whether_samanvay_icon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getSamanvay().isDisplayed();
			
			sa.assertEquals(result, true,"Step40: To check whether samanvay icon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: samanvay icon link is present on the homepage.");
			} else {
				scenario.log("Failed: samanvay icon link is not present on the homepage.");
			}elementscreenshotadd(hp.getSamanvay(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step40: To check whether samanvay icon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step41: To check whether Tia icon link is present on the homepage.")
	public void step41_to_check_whether_tia_icon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getTia().isDisplayed();
			
			sa.assertEquals(result, true,"Step41: To check whether Tia icon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: Tia icon link is present on the homepage.");
			} else {
				scenario.log("Failed: Tia icon link is not present on the homepage.");
			}elementscreenshotadd(hp.getTia(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step41: To check whether Tia icon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step42: To check whether Copywright info is present on the homepage.")
	public void step42_to_check_whether_copywright_info_is_present_on_the_homepage() {
		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getCopywright().isDisplayed();
			
			sa.assertEquals(result, true,"Step42: To check whether Copywright info is present on the homepage.");
			if (result) {
				scenario.log("Passed: Copywright info is present on the homepage.");
			} else {
				scenario.log("Failed: Copywright info is not present on the homepage.");
			}elementscreenshotadd(hp.getCopywright(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step42: To check whether Copywright info is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step43: To check whether eesl Facebook icon link is present on the homepage.")
	public void step43_to_check_whether_eesl_facebook_icon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getFacebook().isDisplayed();
			
			sa.assertEquals(result, true,"Step43: To check whether eesl Facebook icon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: EESL Facebook icon link is present on the homepage.");
			} else {
				scenario.log("Failed: EESL Facebook icon link is not present on the homepage.");
			}elementscreenshotadd(hp.getFacebook(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step43: To check whether eesl Facebook icon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step44: To check whether eesl Youtube icon link is present on the homepage.")
	public void step44_to_check_whether_eesl_youtube_icon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getYoutube().isDisplayed();
			
			sa.assertEquals(result, true,"Step44: To check whether eesl Youtube icon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: EESL Youtube icon link is present on the homepage.");
			} else {
				scenario.log("Failed: EESL Youtube icon link is not present on the homepage.");
			}elementscreenshotadd(hp.getYoutube(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step44: To check whether eesl Youtube icon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step45: To check whether eesl X icon link is present on the homepage.")
	public void step45_to_check_whether_eesl_x_icon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getTwitter().isDisplayed();
			sa.assertEquals(result, true,"Step45: To check whether eesl X icon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: EESL X icon link is present on the homepage.");
			} else {
				scenario.log("Failed: EESL X icon link is not present on the homepage.");
			}elementscreenshotadd(hp.getTwitter(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step45: To check whether eesl X icon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
	}

	@Then("Step46: To check whether eesl Instagram icon link is present on the homepage.")
	public void step46_to_check_whether_eesl_instagram_icon_link_is_present_on_the_homepage() {

		
		try {
			hp = new HomePageElements();
			//sa = new SoftAssert();
			boolean result = hp.getInstagram().isDisplayed();
			
			sa.assertEquals(result, true,"Step46: To check whether eesl Instagram icon link is present on the homepage.");
			if (result) {
				scenario.log("Passed: EESL Instagram icon link is present on the homepage.");
			} else {
				scenario.log("Failed: EESL Instagram icon link is not present on the homepage.");
			}elementscreenshotadd(hp.getInstagram(), scenario);
			
		} catch (Exception e) {
			String message = e.getMessage();
			scenario.log("failed due below error: Please contact Automation Test Developer");
			scenario.log("Error message: "+message);
			sa.assertEquals(true, false, "Element not found");
			failed.add("Step46: To check whether eesl Instagram icon link is present on the homepage.");
			generalscreenshotadd(scenario);
		}
		
	}
	@Then("Failure Reporting")
	public void failure_reporting() {
		boolean empty = failed.isEmpty();
	    if (empty==false) {
	    	for (String string : failed) {
		    	JTextArea area = new JTextArea(string);
		    	area.setForeground(Color.red);
		    	scenario.log("The Failed Test Steps are:");
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
