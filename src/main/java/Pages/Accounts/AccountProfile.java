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

    WebDriver driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(id = "acc2_ileinner")
    @CacheLookup
    WebElement accountNameLabel;

    // endregion


    public AccountProfile(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);

    }

    public String getUrl() {   return driver.getCurrentUrl();   }

}
