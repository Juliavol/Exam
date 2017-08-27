package cases;

import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import utils.commonOps;
import utils.base;

public class sanity extends base{

	static pageObjects.fbSignUp fbsu;
	static pageObjects.fbFooter fbf;
	static pageObjects.fbDevs fbd;
	public WebDriverWait wait = new WebDriverWait(driver, 10);
	commonOps comOps = new commonOps();
	
	@BeforeClass
	public static void startSession() throws ParserConfigurationException, SAXException, IOException{
		base.repInstance();
		System.setProperty("webdriver.chrome.driver", "C:/workspace/selenuimDrivers/chromedriver.exe");
		driver = new ChromeDriver(); //no need to define as WebDriver because it extends base	
		driver.get(getData("URL")); //navigate to url 
		driver.manage().window().maximize();
		
		 
		 fbsu = PageFactory.initElements(driver, pageObjects.fbSignUp.class);
		 fbf = PageFactory.initElements(driver, pageObjects.fbFooter.class);
		 fbd = PageFactory.initElements(driver, pageObjects.fbDevs.class);
	}
	@After
	public void afterTest(){
		base.finalizeTestReport();
	}
	@AfterClass
	public static void closeSession(){
		base.finalizeExtentTestReport();
		driver.quit();
	}
	
	@Test
	public void test1() throws ParserConfigurationException, SAXException, IOException, InterruptedException{

			base.initTestReport("Test1 - attempt login", "text contains what should be an unsuccessful login attempt due to short password and element location on Developers page usin g footer");
			// test = extent.startTest("Test1 - attempt login", "text contains what should be an unsuccessful login attempt due to short password");
			//comOps.verifyElementExists(fbsu.fName);
			//comOps.verifyElementExists(fbsu.lName);
			//comOps.verifyElementExists(fbsu.mobEmail);
			//comOps.verifyElementExists(fbsu.pass);
			//comOps.verifyElementExists(fbsu.bMonth);
			//comOps.verifyElementExists(fbsu.bDay);
			//comOps.verifyElementExists(fbsu.year);
			//comOps.verifyElementExists(fbsu.createBtn);
			//comOps.verifyElementExists(fbsu.createBtn);
			//test.log(LogStatus.PASS, "all searched elements appear on screen");
			fbsu.signUp();
			test.log(LogStatus.INFO, "sign up function completed");
		
			wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("reg_error_inner"), "Your password must be at least 6 characters long. Please try another."));
			comOps.verifyElementExists(fbsu.passErr);
			test.log(LogStatus.INFO, "sign up function completed");
			comOps.verifyValueExists(fbsu.passErr, "Your password must be at least 6 characters long. Please try another.");
			test.log(LogStatus.INFO, "value of error message verified");
			fbf.clickDev();
			test.log(LogStatus.INFO, "developer link clicked");
			wait.until(ExpectedConditions.urlToBe("https://developers.facebook.com/?ref=pf"));
			fbd.devpage();
			test.log(LogStatus.PASS, "TEST1 COMPLETED SUCCESSFULLY");
	
	}
}

