package Pages.Campaigns;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.LookUp.LookUpWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 7/9/16.
 */
public class NewCampaignForm {

    WebDriver driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(id = "cpn1")
    @CacheLookup
    WebElement campaignNameField;

    @FindBy(id = "cpn16")
    @CacheLookup
    WebElement activeCheckbox;

    @FindBy(id = "cpn2")
    @CacheLookup
    WebElement typeDropdown;

    @FindBy(id = "cpn5")
    @CacheLookup
    WebElement startDateField;

    @FindBy(id = "Parent")
    @CacheLookup
    WebElement parentCampaign;

    @FindBy(id = "Parent_lkgt")
    @CacheLookup
    WebElement lookUpIcon;

    @FindBy(name = "save")
    @CacheLookup
    WebElement saveButton;

    //endregion

    public NewCampaignForm(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);
    }

    public NewCampaignForm setCampaignNameField(String text) {
        CommonActions.setValue(campaignNameField, text);

        return this;
    }

    public NewCampaignForm checkActiveCheckbox() {
        CommonActions.check(activeCheckbox);

        return this;
    }

    public NewCampaignForm selectTypeDropdown(String item) {
        CommonActions.selectItem(typeDropdown, item);

        return this;
    }

    public NewCampaignForm setStartDateField(String date) {
        CommonActions.setValue(startDateField, date);

        return this;
    }

    public LookUpWindow clickLookUpIcon() {
        CommonActions.click(lookUpIcon);

        return new LookUpWindow(driver);
    }

    public CampaignProfile clickSaveButton() {
        CommonActions.click(saveButton);

        return new CampaignProfile(driver);
    }
}
