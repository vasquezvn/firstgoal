package Pages.Campaigns;

import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 2/9/16.
 */
public class CampaignsHome {

    WebDriver driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement newButton;

    // endregion

    public CampaignsHome(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);
    }

    public NewCampaignForm clickNewButton() {
        CommonActions.click(newButton);

        return new NewCampaignForm(driver);
    }

    public CampaignProfile goCampaingProfile(String url) {
        driver.navigate().to(url);

        return new CampaignProfile(driver);
    }
}
