package Pages.Leads;

import Framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 2/10/16.
 */
public class LeadProfile {

    WebDriver Driver;
    WebDriverWait wait;

    //region Locators
    @FindBy(id = "ep")
    @CacheLookup
    WebElement leadDescription;

    //endregion

    public LeadProfile(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(Driver, this);
    }

    public String getLeadDescription() {

        return leadDescription.getText();
    }
}
