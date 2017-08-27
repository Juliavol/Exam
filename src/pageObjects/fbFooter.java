package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import utils.base;
import utils.commonOps;
//find badges, developers, pages, groups

public class fbFooter extends base {
    public WebDriver driver;
    @FindBy(how = How.LINK_TEXT, using = "Places")
    public WebElement places; // i used places because badges is not un the footer anymore :)
    @FindBy(how = How.LINK_TEXT, using = "Developers")
    public WebElement developers;
    @FindBy(how = How.LINK_TEXT, using = "Groups")
    public WebElement groups;
    @FindBy(how = How.LINK_TEXT, using = "Pages")
    public WebElement pages;
    commonOps comOps = new commonOps();

    public void clickDev() {
        developers.click();
    }


}
