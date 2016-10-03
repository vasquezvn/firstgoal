package Pages.Accounts;

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
public class AccountProfile {

    WebDriver Driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(id = "acc2_ileinner")
    @CacheLookup
    private WebElement accountNameLabel;

    // endregion


    public AccountProfile(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(driver, this);
    }

    public String getUrl()
    {
        return Driver.getCurrentUrl();
    }

}
