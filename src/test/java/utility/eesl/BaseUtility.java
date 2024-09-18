package utility.eesl;




import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v112.io.IO;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseUtility {
	
	public BaseUtility() {
		PageFactory.initElements(driver, this);
	} 
	public static final String TEXT_BRIGHT_RED    = "\u001B[91m";
	public static final String TEXT_BRIGHT_GREEN  = "\u001B[92m";
	public static String url="";
	public static String clientName="";
	public static String username="";
	public static String password="";
	public static WebDriver driver;
//	public static void main(String[] args) {
//		
//			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("(dd MM yyyy)(HH mm ss)");
//			 LocalDateTime now = LocalDateTime.now();  
//			   String format = dtf.format(now); 
//			   System.out.println(format);
//			
//		}  
	
	public static String currentdate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("(dd MM yyyy)(HH mm ss)");
		 LocalDateTime now = LocalDateTime.now();  
		   String format = dtf.format(now); 
		   return format;
		
	}  
	
	public static void launchChromeBrowser(String url) {
		
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		
		driver.get(url);

	}
	public static void takeScreenshot(String path,String imgname) throws IOException {
		
		TakesScreenshot ts = ((TakesScreenshot) driver);
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String currentdate = currentdate();
		String str = imgname+currentdate;
		
		File destination = new File(path+str+".png");
		
		FileUtils.copyFile(source, destination);
		
}

public static void getJvmRepoting(String jasonpath) {
		
		File f = new File("C:\\Users\\Balaji S\\EESL WORKSPACE\\SmokeTestEcommerce\\Reports\\JVM_Reports");
		//File f = new File("C:\\Users\\Abisha Rajesh R\\git\\SmokeTestEcommerce\\Reports\\JVM Report");
		
		Configuration c = new Configuration(f,"EESL Ecommerce");
		
		c.addClassifications("Operating System","Windows11");
		c.addClassifications("IDE","Eclipse 2023-09 (4.29.0)");
		c.addClassifications("Java_Version","jdk 11");
		c.addClassifications("Selenium_Version","4.10.0");
		c.addClassifications("Cucumber_Version","7.14.1");
		c.addClassifications("Web_Driver_Mananger","5.6.3");
		c.addClassifications("Client_Name","EESL");
		c.addClassifications("URL", "https://eeslpreprod.tangentia.com/");
		List<String> li = new ArrayList<>();
		
		li.add(jasonpath);
		
		ReportBuilder r = new ReportBuilder(li,c);
		r.generateReports();
	}
public static void toMaximize() {
	driver.manage().window().maximize();

}

public static void textBoxClear(WebElement Element) throws AWTException {
	
	Actions ac = new Actions(driver);
	
	ac.moveToElement(Element).click().perform();
	
	
	
	Robot r = new Robot();
	
	r.keyPress(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_A);
	r.keyRelease(KeyEvent.VK_A);
	r.keyRelease(KeyEvent.VK_CONTROL);
	r.keyPress(KeyEvent.VK_DELETE);
	r.keyRelease(KeyEvent.VK_DELETE);
	

	
	
	

}

public static String webTable(int rownum,int columnnum,WebElement Table,boolean buttonclick) {
	
		List<WebElement> rows = Table.findElements(By.tagName("tr"));
		List<WebElement> columns = rows.get(rownum).findElements(By.tagName("td"));
		
		WebElement webElement = columns.get(columnnum);
		String text = webElement.getText();
		if (buttonclick==true) {
			columns.get(columnnum).findElement(By.xpath("//i[@class='icon fa fa-angle-double-right fa-2x']")).click();
		}

		return text;
	

		
	
	
}
public static String webTableinnerText(int rownum,int columnnum,WebElement Table) {
	
	List<WebElement> rows = Table.findElements(By.tagName("tr"));
	List<WebElement> columns = rows.get(rownum).findElements(By.xpath("td"));
	
	String text = columns.get(columnnum).getAttribute("innerText");
	
	
	return text;


	


}
public static Integer webtableheadcount(int rownum,WebElement Table) {
	
	List<WebElement> rows = Table.findElements(By.tagName("tr"));
	List<WebElement> columns = rows.get(rownum).findElements(By.tagName("th"));
	
	int size = columns.size();
	return size;
	
	
}




public static String webtableheadinnerText(int columnnum,WebElement Table) {
	
	List<WebElement> rows = Table.findElements(By.tagName("tr"));
	List<WebElement> columns = rows.get(0).findElements(By.tagName("th"));
	boolean displayed = columns.get(columnnum).isDisplayed();
	String text = null;
	if (displayed) {
		text = columns.get(columnnum).getAttribute("innerText");
		
	}	
	return text;
}

public static String webtablehead(int rownum,int columnnum,WebElement Table) {
	
	List<WebElement> rows = Table.findElements(By.tagName("tr"));
	List<WebElement> columns = rows.get(rownum).findElements(By.tagName("th"));
	
	String text = columns.get(columnnum).getText();
	return text;
	
	
}
public static Integer webtablerowcount(WebElement Table) {
	
	List<WebElement> rows = Table.findElements(By.tagName("tr"));
	int size = rows.size();
	size=size-1;
	return size;
	
	
}

public static void jsSendkeys(WebElement element,String passdata) {
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].setAttribute('value',"+passdata+")", element);
}
public static void jsgetvlaue(WebElement element) {
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].getAttribute('value')", element);
}
public static void jsclick(WebElement element) {
	
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("arguments[0].click()", element);
}
public static void fwait(WebElement Element) {
	
	Wait<WebDriver> f = new FluentWait<WebDriver>(driver)
			.withTimeout(java.time.Duration.ofSeconds(60))
			.pollingEvery(java.time.Duration.ofSeconds(1))
			.ignoring(NoSuchElementException.class);
	
	f.until(ExpectedConditions.visibilityOf(Element));
	
}

public static void fwaitclick(WebElement Element) {
	
	Wait<WebDriver> f = new FluentWait<WebDriver>(driver)
			.withTimeout(java.time.Duration.ofSeconds(60))
			.pollingEvery(java.time.Duration.ofSeconds(1))
			.ignoring(NoSuchElementException.class);
	
	f.until(ExpectedConditions.elementToBeClickable(Element));
	
}

public static void fwaitpage(String Title) {
	
	Wait<WebDriver> f = new FluentWait<WebDriver>(driver)
			.withTimeout(java.time.Duration.ofSeconds(20))
			.pollingEvery(java.time.Duration.ofSeconds(1))
			.ignoring(NoSuchElementException.class);
	
	f.until(ExpectedConditions.titleContains(Title));
	
}
public static void implicitywait(Integer waittime) {
	
	driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(waittime));		
	
}
public static void apiPOPush(String sellerID,String buyerID,String ponumber, String releasedate,String shipdate,String deliverydate,String canceldate) {
	
	HttpClient httpClient = HttpClients.createDefault();
	
	HttpPost httpPost = new HttpPost("https://gateway-qa.tangentia.com:10001/Doc850/PushPO");
	
	httpPost.setHeader("Content-Type", "application/json");
	
	String requestbody = "{\r\n"
			+ "    \"Item\": {\r\n"
			+ "      \"version\": \"1.2\",\r\n"
			+ "      \"SellerID\": \""+sellerID+"\",\r\n"
			+ "      \"BuyerID\": \""+buyerID+"\",\r\n"
			+ "      \"PONumber\": \""+ponumber+"\",\r\n"
			+ "      \"IsPOChange\": 0,\r\n"
			+ "      \"EDIFileName\": \""+ponumber+"\",\r\n"
			+ "      \"POReleaseDate\": \""+releasedate+" 00:00:00\",\r\n"
			+ "      \"ShipDate\": \""+shipdate+" 00:00:00\",\r\n"
			+ "      \"DeliveryDate\": \""+deliverydate+" 00:00:00\",\r\n"
			+ "      \"CancelDate\": \""+canceldate+" 00:00:00\",\r\n"
			+ "      \"BillToCode\": \"\",\r\n"
			+ "      \"BillToName\": \"Test BTN\",\r\n"
			+ "      \"BillToAddress1\": \"Test BTA1\",\r\n"
			+ "      \"BillToAddress2\": \"Test BTA2\",\r\n"
			+ "      \"BillToCity\": \"Test BTCity\",\r\n"
			+ "      \"BillToState\": \"AR\",\r\n"
			+ "      \"BillToZip\": \"72716\",\r\n"
			+ "      \"BillToCountry\": \"US\",\r\n"
			+ "      \"BillToPrimaryContact\": \"\",\r\n"
			+ "      \"BillToPhoneNo\": \"\",\r\n"
			+ "      \"ShipToCode\": \"0078742029993\",\r\n"
			+ "      \"ShipToName\": \"Test STN\",\r\n"
			+ "      \"ShipToAddress1\": \"Test STA1\",\r\n"
			+ "      \"ShipToAddress2\": \"Test STA2\",\r\n"
			+ "      \"ShipToCity\": \"Test STCity\",\r\n"
			+ "      \"ShipToState\": \"WI\",\r\n"
			+ "      \"ShipToZip\": \"54751\",\r\n"
			+ "      \"ShipToCountry\": \"US\",\r\n"
			+ "      \"ShipToPrimaryContact\": \"\",\r\n"
			+ "      \"ShipToPhoneNo\": \"\",\r\n"
			+ "      \"SoldToCode\": \"452318923\",\r\n"
			+ "      \"SoldToName\": \"\",\r\n"
			+ "      \"SoldToAddress1\": \"452318923\",\r\n"
			+ "      \"SoldToAddress2\": \"\",\r\n"
			+ "      \"SoldToCity\": \"\",\r\n"
			+ "      \"SoldToState\": \"\",\r\n"
			+ "      \"SoldToZip\": \"\",\r\n"
			+ "      \"SoldToCountry\": \"\",\r\n"
			+ "      \"SoldToPrimaryContact\": \"\",\r\n"
			+ "      \"SoldToPhoneNo\": \"\",\r\n"
			+ "      \"VendorNo\": \"\",\r\n"
			+ "      \"Currency\": \"USD\",\r\n"
			+ "      \"TotalPOItems\": \"\",\r\n"
			+ "      \"TotalAmount\": \"\",\r\n"
			+ "      \"TotalOrderedQuantities\": \"\",\r\n"
			+ "      \"AdditionalInfo\": \"\",\r\n"
			+ "      \"controL_NUMBER1\": \"850100515\",\r\n"
			+ "      \"controL_NUMBER2\": \"850100515\",\r\n"
			+ "      \"controL_NUMBER3\": \"106259\",\r\n"
			+ "      \"controL_NUMBER4\": \"\",\r\n"
			+ "      \"ShipNotBefore\": \"20230609 00:00:00\",\r\n"
			+ "      \"ShipNoLaterThan\": \"20230624 00:00:00\",\r\n"
			+ "      \"DoNotDeliverAfter\": \"20230626 00:00:00\",\r\n"
			+ "      \"MustArriveBy\": \"20230629 00:00:00\",\r\n"
			+ "      \"Department\": \"00092\",\r\n"
			+ "      \"PromotionalEvent\": \"POS REPLEN\",\r\n"
			+ "      \"AllowanceDescription\": \"Unsaleable Merchandise Allowance\",\r\n"
			+ "      \"AllowancePercent\": \".47\",\r\n"
			+ "      \"AllowanceTotal\": \"2154\",\r\n"
			+ "      \"Allowance\": \"Allowance\",\r\n"
			+ "      \"PaymentTerms\": \"2% 30 Net  45\",\r\n"
			+ "      \"SupplierNumber\": \"452318923\",\r\n"
			+ "      \"SupplierStockNumber\": \"\",\r\n"
			+ "      \"POMasterItemDetails\": [\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"001\",\r\n"
			+ "          \"ProductCode\": \"100\",\r\n"
			+ "          \"ProductUPC\": \"100\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"100\",\r\n"
			+ "          \"ProductDescription\": \"Product1\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"16\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"5\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"002\",\r\n"
			+ "          \"ProductCode\": \"200\",\r\n"
			+ "          \"ProductUPC\": \"200\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"200\",\r\n"
			+ "          \"ProductDescription\": \"Product2\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"15\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"20\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"003\",\r\n"
			+ "          \"ProductCode\": \"300\",\r\n"
			+ "          \"ProductUPC\": \"300\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"300\",\r\n"
			+ "          \"ProductDescription\": \"Product3\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"20\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"5\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"004\",\r\n"
			+ "          \"ProductCode\": \"400\",\r\n"
			+ "          \"ProductUPC\": \"400\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"400\",\r\n"
			+ "          \"ProductDescription\": \"Product4\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"35\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"10\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"005\",\r\n"
			+ "          \"ProductCode\": \"500\",\r\n"
			+ "          \"ProductUPC\": \"500\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"500\",\r\n"
			+ "          \"ProductDescription\": \"Product5\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"50\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"20\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"006\",\r\n"
			+ "          \"ProductCode\": \"600\",\r\n"
			+ "          \"ProductUPC\": \"600\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"600\",\r\n"
			+ "          \"ProductDescription\": \"Product6\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"25\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"10\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"007\",\r\n"
			+ "          \"ProductCode\": \"700\",\r\n"
			+ "          \"ProductUPC\": \"700\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"700\",\r\n"
			+ "          \"ProductDescription\": \"Product7\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"25\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"10\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"008\",\r\n"
			+ "          \"ProductCode\": \"800\",\r\n"
			+ "          \"ProductUPC\": \"800\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"800\",\r\n"
			+ "          \"ProductDescription\": \"Product8\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"40\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"10\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"009\",\r\n"
			+ "          \"ProductCode\": \"900\",\r\n"
			+ "          \"ProductUPC\": \"900\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"900\",\r\n"
			+ "          \"ProductDescription\": \"Product9\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"25\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"10\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"010\",\r\n"
			+ "          \"ProductCode\": \"1000\",\r\n"
			+ "          \"ProductUPC\": \"1000\",\r\n"
			+ "          \"VendorProductCode\": \"84400\",\r\n"
			+ "          \"BuyerProductCode\": \"1000\",\r\n"
			+ "          \"ProductDescription\": \"Product10\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"5\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"25\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"10\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"POItemNumber\": \"011\",\r\n"
			+ "          \"ProductCode\": \"1100\",\r\n"
			+ "          \"ProductUPC\": \"1100\",\r\n"
			+ "          \"VendorProductCode\": \"74850\",\r\n"
			+ "          \"BuyerProductCode\": \"1100\",\r\n"
			+ "          \"ProductDescription\": \"Product11\",\r\n"
			+ "          \"Color\": \"Black\",\r\n"
			+ "          \"Size\": \"8\",\r\n"
			+ "          \"Dimension\": \"\",\r\n"
			+ "          \"OrderedQuantity\": \"15\",\r\n"
			+ "          \"QuantityUOM\": \"CA\",\r\n"
			+ "          \"UnitPrice\": \"20\",\r\n"
			+ "          \"RetailerPrice\": \"\",\r\n"
			+ "          \"NetPrice\": \"\",\r\n"
			+ "          \"ReqShipDate\": \"\"\r\n"
			+ "        }\r\n"
			+ "        \r\n"
			+ "      ],\r\n"
			+ "      \"Allowances\": [\r\n"
			+ "        {\r\n"
			+ "          \"AllowanceType\": \"Allowance\",\r\n"
			+ "          \"AllowanceDescription\": \"Unsaleable Merchandise Allowance\",\r\n"
			+ "          \"AllowancePercentage\": \".50\",\r\n"
			+ "          \"AllowanceTotal\": \"200.12\"\r\n"
			+ "        },\r\n"
			+ "        {\r\n"
			+ "          \"AllowanceType\": \"Allowance\",\r\n"
			+ "          \"AllowanceDescription\": \"Quantity Discount\",\r\n"
			+ "          \"AllowancePercentage\": \".16\",\r\n"
			+ "          \"AllowanceTotal\": \"140.34\"\r\n"
			+ "        }\r\n"
			+ "      ]\r\n"
			+ "    }\r\n"
			+ "  }\r\n"
			+ "  ";
	try {
	StringEntity entity = new StringEntity(requestbody);
    httpPost.setEntity(entity);

    // Execute HTTP Post request
   HttpResponse response = httpClient.execute(httpPost);

    // Parse response
    int statusCode = response.getStatusLine().getStatusCode();
    String responseBody = EntityUtils.toString(response.getEntity());

    // Log response
    System.out.println("Response Status: " + statusCode);
    System.out.println("Response Body: " + responseBody);

    // Check for success status
    if (statusCode == 200) {
        System.out.println("Data pushed successfully to the weather API.");
    } else {
        System.out.println("Failed to push data. Response code: " + statusCode);
        // Additional error handling can be added here based on the response status code
    }
} catch (IOException e) {
    e.printStackTrace();
    // Log any exceptions or errors
    System.err.println("Failed to make API call: " + e.getMessage());
}
}

public static boolean pdfReader(String containstext) throws IOException,FileNotFoundException, TesseractException {
	boolean result = false;
	
			
	File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File destination = new File("C:\\Users\\Balaji S\\eclipse-workspace1\\TiaGateway\\OCR\\image1.png");
	
	FileUtils.copyFile(screenshotFile, destination);
	//FileInputStream f = new FileInputStream("C:\\Users\\Balaji S\\eclipse-workspace1\\TiaGateway\\OCR\\1.png");

    ITesseract tesseract = new Tesseract();
    String extractedText = tesseract.doOCR(new File("C:\\Users\\Balaji S\\eclipse-workspace1\\TiaGateway\\OCR\\image1.png"));

    // Output extracted text
    System.out.println("Extracted PDF content: \n" + extractedText);

   
	
	boolean contains = extractedText.contains(containstext);
	if (contains==true) {
		result = true;
	}else {
		result = false;
	}
	return result;
	
}

public static void generalscreenshotadd(Scenario scenario) {
	TakesScreenshot ts = (TakesScreenshot)driver;
	

	byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
	scenario.attach(screenshotAs, "img/png", "Screenshot Attached");
}
public static void fullpagescreenshotadd(Scenario scenario) throws IOException {
	//TakesScreenshot ts = (TakesScreenshot)driver;
	Screenshot screenshot = new AShot()
            .shootingStrategy(ShootingStrategies.viewportPasting(1000))
            .takeScreenshot(driver);
          BufferedImage image = screenshot.getImage();
          byte[] imageInBytes = convertBufferedImageToByteArray(image, "png");

	//byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
	scenario.attach(imageInBytes, "img/png", "Screenshot Attached");
}
public static void elementscreenshotadd(WebElement element,Scenario scenario) {
	byte[] screenshotAs = element.getScreenshotAs(OutputType.BYTES);
	scenario.attach(screenshotAs, "img/png", "Screenshot Attached");
}
public static byte[] convertBufferedImageToByteArray(BufferedImage image, String format) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, format, baos);  // 'format' can be "png", "jpg", etc.
    baos.flush();
    byte[] imageInBytes = baos.toByteArray();
    baos.close();
    return imageInBytes;
}

}



