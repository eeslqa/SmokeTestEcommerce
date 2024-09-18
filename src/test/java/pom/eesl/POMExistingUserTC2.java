package pom.eesl;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.eesl.BaseUtility;

public class POMExistingUserTC2 extends BaseUtility {
	
	public POMExistingUserTC2() {
		PageFactory.initElements(driver, this);
	}
@FindBy(xpath="//a[contains(text(),'Login')]") private WebElement login;
@FindBy(xpath="//h1[contains(text(),'Welcome, Please Log In!')]") private WebElement welcomemsg;
@FindBy(xpath="//span[@class='pi-mail-2 px_icon']") private WebElement emailicon;
@FindBy(xpath="//span[@class='pi-padlock1 px_icon']") private WebElement passwordicon;
@FindBy(xpath="//img[@src='/Themes/EESL/Content/images/eye-black.png']") private WebElement passlookupenable;
@FindBy(xpath="//img[@src='/Themes/EESL/Content/images/eye-off.png']") private WebElement passlookupdisable;
@FindBy(xpath="//input[@id='Email']") private WebElement emailtextbox;
@FindBy(xpath="//input[@id='Password']") private WebElement passtextbox;
@FindBy(xpath="//label[contains(text(),'Email OR Phone')]") private WebElement emaillabel;
@FindBy(xpath="//label[contains(text(),'Password')]") private WebElement passlabel;
@FindBy(xpath="//button[contains(text(),' Login With OTP ')]") private WebElement loginOTPlink;
@FindBy(xpath="//button[@class='button-1 login-button primary-btn']") private WebElement loginButton;
@FindBy(xpath="//p[contains(text(),'Don’t Have a Account ?')]") private WebElement dontACClabel;
@FindBy(xpath="//a[contains(text(),' Register')]") private WebElement registerlink;
@FindBy(xpath="//div[contains(text(),'- or -')]") private WebElement orlabel;
@FindBy(xpath="//a[@class='facebook-btn']") private WebElement fbloginbutton;
@FindBy(xpath="//a[@class='google-btn']") private WebElement googleloginbutton;
@FindBy(xpath="//span[@class='pi-user-6']")private WebElement signupLoginicon;
@FindBy(xpath="//div[contains(text(),'Login was unsuccessful. Please correct the errors and try again.')]")private WebElement invaliderrormsg;
@FindBy(xpath="//h4[@class='customer-name-text']")private WebElement loginaccount;
@FindBy(xpath="//a[contains(text(),'My account')]")private WebElement myaccount;
@FindBy(xpath="//h1[contains(text(),'My account - Customer info')]")private WebElement customerinfolabel;
@FindBy(xpath="//a[contains(text(),'Business Profiles')]")private WebElement bussinessprofiles;
@FindBy(xpath="//th[contains(text(),'GST Number')]")private WebElement gstnumber;
@FindBy(xpath="//a[contains(text(),'Log out')]")private WebElement logout;

public WebElement getLogout() {
	return logout;
}
public WebElement getBussinessprofiles() {
	return bussinessprofiles;
}
public WebElement getGstnumber() {
	return gstnumber;
}
public WebElement getLoginaccount() {
	return loginaccount;
}
public WebElement getMyaccount() {
	return myaccount;
}
public WebElement getCustomerinfolabel() {
	return customerinfolabel;
}
public WebElement getInvaliderrormsg() {
	return invaliderrormsg;
}
public WebElement getSignupLoginicon() {
	return signupLoginicon;
}
public WebElement getLogin() {
	return login;
}
public WebElement getWelcomemsg() {
	return welcomemsg;
}
public WebElement getEmailicon() {
	return emailicon;
}
public WebElement getPasswordicon() {
	return passwordicon;
}
public WebElement getPasslookupenable() {
	return passlookupenable;
}
public WebElement getPasslookupdisable() {
	return passlookupdisable;
}
public WebElement getEmailtextbox() {
	return emailtextbox;
}
public WebElement getPasstextbox() {
	return passtextbox;
}
public WebElement getEmaillabel() {
	return emaillabel;
}
public WebElement getPasslabel() {
	return passlabel;
}
public WebElement getLoginOTPlink() {
	return loginOTPlink;
}
public WebElement getLoginButton() {
	return loginButton;
}
public WebElement getDontACClabel() {
	return dontACClabel;
}
public WebElement getRegisterlink() {
	return registerlink;
}
public WebElement getOrlabel() {
	return orlabel;
}
public WebElement getFbloginbutton() {
	return fbloginbutton;
}
public WebElement getGoogleloginbutton() {
	return googleloginbutton;
}



}
