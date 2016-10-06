package Pages.Campaigns;

import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 2/9/16.
 */
public class CampaignProfile {

    WebDriver driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(className = "pageDescription")
    @CacheLookup
    WebElement campaignNameLabel;

    @FindBy(name = "del")
    @CacheLookup
    WebElement DeleteButton;

    // endregion


    public CampaignProfile(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);

    }

    public String getCampaignNameLabel() { return campaignNameLabel.getText(); }

    public CampaignsHome clickDeleteButton() {
        CommonActions.click(DeleteButton);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.switchTo().defaultContent();

        return new CampaignsHome(driver);
    }

    public String getUrl()
    {
        return driver.getCurrentUrl();
    }

}
