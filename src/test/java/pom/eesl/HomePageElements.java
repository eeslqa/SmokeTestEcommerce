package pom.eesl;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.eesl.BaseUtility;



public class HomePageElements extends BaseUtility {
	
	public HomePageElements() {
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//*[contains(text(),'EESL India - QA . EESL India - QA')]")private WebElement webpageTitle;
@FindBy(xpath="//button[@id='homepage-close-button']")private WebElement popup;
@FindBy(xpath="(//img[@src='https://eeslpreprod.tangentia.com/images/thumbs/0000174_EESL Logo Branding C2C (1)-05.png'])[2]")private WebElement eeslLogo;
@FindBy(xpath="//input[@placeholder='Search store']")private WebElement searchbar;
@FindBy(xpath = "(//span[@class='pi-search'])[2]")private WebElement searchbutton;
public WebElement getSearchbutton() {
	return searchbutton;
}

@FindBy(xpath="//span[@class='pi-user-6']")private WebElement signupLoginicon;
@FindBy(xpath="//select[@id='customerlanguage']")private WebElement languagedropdown;
@FindBy(xpath="//a[@class='pi-heart']")private WebElement wishlisticon;
@FindBy(xpath="//div[@class='header-lower']//li[4]//a[1]")private WebElement carticon;
@FindBy(xpath="//span[normalize-space()='BETA']")private WebElement betaLabel;
@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Electric Cooking']")private WebElement electricCookingmenu;
@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Lighting']")private WebElement lightingmenu;
@FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='About Us']")private WebElement aboutUs;
@FindBy(xpath="//a[contains(text(),' Cooling ')]")private WebElement coolingmenu;
@FindBy(xpath="//a[contains(text(),'URJAVEER')]")private WebElement urjaveermenu;
@FindBy(xpath="//a[contains(text(),'Know More')]")private WebElement knowmoremenu;
@FindBy(xpath="//span[contains(text(),'Signup/Login')]")private WebElement signuploginLabel;
@FindBy(xpath="//h1")private WebElement shopbycategorylabel;
@FindBy(xpath="//h2[contains(text(),'Featured products')]")private WebElement featuredproductlabel;
@FindBy(xpath="//button[@role='presentation']")private List<WebElement> productnavigationbutton;
@FindBy(xpath="//a[contains(text(),'Search')]")private WebElement searchlink;
@FindBy(xpath="//a[contains(text(),'Refund Policy')]")private WebElement refundPolicy;
@FindBy(xpath="//a[contains(text(),'Order Cancellation Policy')]")private WebElement orderCancellation;
@FindBy(xpath="//a[contains(text(),'Shipping & returns')]")private WebElement shippingLink;
@FindBy(xpath="//a[contains(text(),'Privacy notice')]")private WebElement privacyLink;
@FindBy(xpath="//a[contains(text(),'Conditions of Use')]")private WebElement conditionsLink;
@FindBy(xpath="//a[contains(text(),'About Us')]")private WebElement aboutLink;
@FindBy(xpath="//a[contains(text(),'Contact us')]")private WebElement contactusLink;
@FindBy(xpath="//a[contains(text(),'Recently viewed products')]")private WebElement recentlyviewedproductslink;
public WebElement getContactusLink() {
	return contactusLink;
}

@FindBy(xpath="//a[contains(text(),'Replacement & Return Policy')]")private WebElement replacementReturnPolicylink;
@FindBy(xpath="//a[contains(text(),'Warranty Policy')]")private WebElement warrantyPolicylink;
@FindBy(xpath="//a[contains(text(),'FAQ')]")private WebElement faqlink;


public WebElement getFaqlink() {
	return faqlink;
}
public WebElement getReplacementReturnPolicylink() {
	return replacementReturnPolicylink;
}
public WebElement getWarrantyPolicylink() {
	return warrantyPolicylink;
}

@FindBy(xpath="//a[contains(text(),'Compare products list')]")private WebElement compareproductslistlink;
@FindBy(xpath="//a[contains(text(),'Coming Soon')]")private WebElement comingSoonlink;
@FindBy(xpath="//a[contains(text(),'My account')]")private WebElement myaccountlink;
@FindBy(xpath="//a[contains(text(),'Orders')]")private WebElement orderslink;
@FindBy(xpath="//a[contains(text(),'Shopping cart')]")private WebElement shoppingcartlink;
@FindBy(xpath="//a[contains(text(),'Wishlist')]")private WebElement wishlistlink;
@FindBy(xpath="//img[@src='/Themes/EESL/Content/images/Make_In_India.png']")private WebElement makeinindia;
@FindBy(xpath="//img[@src='/Themes/EESL/Content/images/swachh-bharat.jpg']")private WebElement swatchbharat;
@FindBy(xpath="//img[@src='/Themes/EESL/Content/images/my_gov.jpg']")private WebElement mygov;
@FindBy(xpath="//img[@src='/Themes/EESL/Content/images/samanvay.png']")private WebElement samanvay;
@FindBy(xpath="//img[@src='/Themes/EESL/Content/images/tia.png']")private WebElement tia;
@FindBy(xpath="//a[@href='https://www.facebook.com/EESLIndia']")private WebElement facebook;
@FindBy(xpath="//a[@href='https://twitter.com/EESL_India']")private WebElement twitter;
@FindBy(xpath="//a[@href='https://www.youtube.com/channel/UC27eyqekKsTNBVW3dAsItBA']")private WebElement youtube;
@FindBy(xpath="//a[@href='https://www.instagram.com/eeslawarenessmission/']")private WebElement instagram;
@FindBy(xpath="//span[contains(text(),'Copyright')]")private WebElement copywright;

public WebElement getEeslLogo() {
	return eeslLogo;
}
public WebElement getSearchbar() {
	return searchbar;
}
public WebElement getSignupLoginicon() {
	return signupLoginicon;
}
public WebElement getLanguagedropdown() {
	return languagedropdown;
}
public WebElement getWishlisticon() {
	return wishlisticon;
}
public WebElement getCarticon() {
	return carticon;
}
public WebElement getBetaLabel() {
	return betaLabel;
}
public WebElement getElectricCookingmenu() {
	return electricCookingmenu;
}
public WebElement getLightingmenu() {
	return lightingmenu;
}
public WebElement getAboutUs() {
	return aboutUs;
}
public WebElement getCoolingmenu() {
	return coolingmenu;
}
public WebElement getUrjaveermenu() {
	return urjaveermenu;
}
public WebElement getKnowmoremenu() {
	return knowmoremenu;
}
public WebElement getSignuploginLabel() {
	return signuploginLabel;
}
public WebElement getShopbycategorylabel() {
	return shopbycategorylabel;
}
public WebElement getFeaturedproductlabel() {
	return featuredproductlabel;
}
public List<WebElement> getProductnavigationbutton() {
	return productnavigationbutton;
}
public WebElement getSearchlink() {
	return searchlink;
}
public WebElement getRefundPolicy() {
	return refundPolicy;
}
public WebElement getOrderCancellation() {
	return orderCancellation;
}
public WebElement getShippingLink() {
	return shippingLink;
}
public WebElement getPrivacyLink() {
	return privacyLink;
}
public WebElement getConditionsLink() {
	return conditionsLink;
}
public WebElement getAboutLink() {
	return aboutLink;
}
public WebElement getRecentlyviewedproductslink() {
	return recentlyviewedproductslink;
}
public WebElement getCompareproductslistlink() {
	return compareproductslistlink;
}
public WebElement getComingSoonlink() {
	return comingSoonlink;
}
public WebElement getMyaccountlink() {
	return myaccountlink;
}
public WebElement getOrderslink() {
	return orderslink;
}
public WebElement getShoppingcartlink() {
	return shoppingcartlink;
}
public WebElement getWishlistlink() {
	return wishlistlink;
}
public WebElement getMakeinindia() {
	return makeinindia;
}
public WebElement getSwatchbharat() {
	return swatchbharat;
}
public WebElement getMygov() {
	return mygov;
}
public WebElement getSamanvay() {
	return samanvay;
}
public WebElement getTia() {
	return tia;
}
public WebElement getFacebook() {
	return facebook;
}
public WebElement getTwitter() {
	return twitter;
}
public WebElement getYoutube() {
	return youtube;
}
public WebElement getInstagram() {
	return instagram;
}
public WebElement getCopywright() {
	return copywright;
}
public WebElement getPopup() {
	return popup;
}
public void setPopup(WebElement popup) {
	this.popup = popup;
}
public WebElement getWebpageTitle() {
	return webpageTitle;
}	

}
