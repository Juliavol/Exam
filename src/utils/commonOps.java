package utils;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class commonOps extends base {

    public void verifyElementExists(WebElement elem) throws IOException, ParserConfigurationException, SAXException {

        try {
            elem.isDisplayed();
            System.out.println("element is displayed" + elem);
            test.log(LogStatus.PASS, "element exists: " + elem);
        } catch (Exception e) {
            //insert report writing
            System.out.println("element does not exist ");
            test.log(LogStatus.FAIL, (elem + " does not exist, See Screenshot" + test.addScreenCapture(CaptureScreen())));
            fail("Element does not exist ");
        }
    }

    public void selectDropDown(WebElement elem, String dropVal) throws IOException, ParserConfigurationException, SAXException {
        try {
            Select myValue = new Select(elem);
            myValue.selectByValue(dropVal);
            System.out.println("element selected " + dropVal);
            test.log(LogStatus.PASS, "element selected: " + elem);
        } catch (Exception e) {

            System.out.println("element was not selected " + dropVal + e.getMessage());
            test.log(LogStatus.FAIL, "element was not selected: " + elem + test.addScreenCapture(CaptureScreen()));
        }
    }

    public void verifyValueExists(WebElement elem, String expectedVal) throws IOException, ParserConfigurationException, SAXException {

        try {
            String actual = elem.getText();
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#reg_error_inner")));
            assertEquals(expectedVal, actual);
            System.out.println("element exists with correct value ");
            System.out.println("actual value is: " + "' " + actual + " '");
        } catch (Exception e) {
            //insert report writing
            System.out.println("element does not exist " + e.getMessage());
            test.log(LogStatus.FAIL, "element does not exist, See Screenshot" + e.getMessage() + test.addScreenCapture(CaptureScreen()));
            fail("Element value does not exist ");
        } catch (AssertionError ea) {
            System.out.println("Assertion failed " + ea.getMessage());
            test.log(LogStatus.FAIL, "assert Failed" + ea.getMessage() + test.addScreenCapture(CaptureScreen()));
            fail("Assert failed ");
        }
    }


}
