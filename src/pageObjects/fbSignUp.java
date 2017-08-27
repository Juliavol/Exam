package pageObjects;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utils.base;
import utils.commonOps;

public class fbSignUp extends base {
//https://www.facebook.com/
	public WebDriver driver;
	public WebDriverWait wait = new WebDriverWait(driver, 10);
	commonOps comOps = new commonOps();
	public static ExtentReports extent;
	public static ExtentTest test;
	
	@FindBy (how = How.ID, using = "u_0_7")
	public WebElement fName;
	@FindBy (how = How.ID, using = "u_0_9")
	public WebElement lName;
	@FindBy (how = How.ID, using = "u_0_c")
	public WebElement mobEmail;
	@FindBy (how = How.ID, using = "u_0_f")
	public WebElement mobEmail2;
	@FindBy (how = How.ID, using = "u_0_j")
	public WebElement pass;
	@FindBy (how = How.ID, using = "month")
	public WebElement bMonth;
	@FindBy (how = How.ID, using = "day")
	public WebElement bDay;
	@FindBy (how = How.ID, using = "year")
	public WebElement year;
	@FindBy (how = How.ID, using = "u_0_4")
	public WebElement gender;
	@FindBy (how = How.CSS, using = "#u_0_p")
	public WebElement createBtn;
	@FindBy (how = How.ID, using = "reg_error_inner")
	public WebElement passErr;     
	
	public fbSignUp (WebDriver driver){
		this.driver = driver;
		
		}
	
	
	public void signUp() throws ParserConfigurationException, SAXException, IOException{
		extent = new ExtentReports("C:/workspace/Selenium_reports/EXEC.html");
		comOps.verifyElementExists(fName);
		fName.sendKeys("Julia");
		test.log(LogStatus.PASS, "sendKeys fn complete");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("u_0_9")));
		comOps.verifyElementExists(lName);
		lName.sendKeys("Shub");
		test.log(LogStatus.PASS, "sendKeys last name complete");
		comOps.verifyElementExists(mobEmail);
		mobEmail.sendKeys("juliatest82@gmail.com");
		test.log(LogStatus.PASS, "email1 pass");
		comOps.verifyElementExists(mobEmail2);
		mobEmail2.sendKeys("juliatest82@gmail.com");
		comOps.verifyElementExists(pass);
		pass.sendKeys("12345");
		test.log(LogStatus.PASS, "email2 pass");
		test.log(LogStatus.PASS, "sendKeys complete");
		comOps.verifyElementExists(bDay);
		comOps.selectDropDown(bDay, getData("bDay"));
		comOps.verifyElementExists(bMonth);
		comOps.selectDropDown(bMonth, getData("bMonth"));	
		comOps.verifyElementExists(year);
		comOps.selectDropDown(year, getData("year"));
		test.log(LogStatus.PASS, "getData complete");
		gender.click();
		comOps.verifyElementExists(createBtn);
		createBtn.click();
		test.log(LogStatus.PASS, "sign up attempt complete");
	}

}
