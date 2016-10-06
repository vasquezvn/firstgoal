package Pages.Opportunities;

import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 2/10/16.
 */
public class OpportunitiesHome {

    WebDriver driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement newbutton;

    // endregion

    public OpportunitiesHome(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);
    }

    public NewOpportunityForm clickNewButton() {
        CommonActions.click(newbutton);

        return new NewOpportunityForm(driver);
    }

    public OpportunityProfile goOpportunityProfile(String url) {
        driver.navigate().to(url);

        return new OpportunityProfile(driver);
    }
}
