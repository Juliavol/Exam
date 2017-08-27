package pageObjects;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.xml.sax.SAXException;
import utils.base;
import utils.commonOps;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class fbDevs extends base {
    public WebDriver driver;
    @FindBy(how = How.CSS, using = "body > div._li._4xit > div.clearfix._ikh > div > div._4i-k > section:nth-child(1) > div > a:nth-child(1) > div > div._3pte")
    public WebElement devLoginURL;
    @FindBy(how = How.CSS, using = "body > div._li._4xit > div.clearfix._ikh > div > div._4i-k > section:nth-child(1) > div > a:nth-child(2) > div > div._3pte")
    public WebElement sharingOnFBURL;
    @FindBy(how = How.CSS, using = "body > div._li._4xit > div.clearfix._ikh > div > div._4i-k > section:nth-child(1) > div > a:nth-child(4) > div > div._3pte")
    public WebElement fbAnalyticsURL;
    @FindBy(how = How.CSS, using = "body > div._li._4xit > div.clearfix._ikh > div > div._4i-k > section:nth-child(1) > div > a:nth-child(5) > div > div._3pte")
    public WebElement mobMonetizationURL;
    @FindBy(how = How.CSS, using = "body > div._li._4xit > div.clearfix._ikh > div > div._4i-k > section:nth-child(1) > div > a:nth-child(6) > div > div._3pte")
    public WebElement messPlatformURL;
    @FindBy(how = How.CSS, using = "body > div._li._4xit > div.clearfix._ikh > div > div._4i-k > section:nth-child(1) > div > a:nth-child(7) > div > div._3pte")
    public WebElement instaPlatformURL;
    commonOps comOps = new commonOps();

    public void devpage() throws IOException, ParserConfigurationException, SAXException {

        comOps.verifyElementExists(messPlatformURL);
        test.log(LogStatus.INFO, "messenger platform url located");

    }
}
