package testrunner.eesl;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utility.eesl.BaseUtility;

@RunWith(Cucumber.class)

@CucumberOptions(features = "C:\\Users\\Balaji S\\EESL WORKSPACE\\SmokeTestEcommerce\\src\\test\\resources\\EESL\\Features",glue ="major.eesl",dryRun=false,monochrome = true,plugin = {
		"html:C:\\Users\\Balaji S\\EESL WORKSPACE\\SmokeTestEcommerce\\Reports\\HTML_Reports\\eeslReport.html",
		"json:C:\\Users\\Balaji S\\EESL WORKSPACE\\SmokeTestEcommerce\\Reports\\Json_Reports\\eeslReport.json",
		"junit:C:\\Users\\Balaji S\\EESL WORKSPACE\\SmokeTestEcommerce\\Reports\\Junit_Reports\\eeslReport.xml",})

public class TestRunner{
	@AfterClass
	 
	 public static void jvmreport() {
		
		 BaseUtility.getJvmRepoting("C:\\Users\\Balaji S\\EESL WORKSPACE\\SmokeTestEcommerce\\Reports\\Json_Reports\\eeslReport.json");

	}
	

}


