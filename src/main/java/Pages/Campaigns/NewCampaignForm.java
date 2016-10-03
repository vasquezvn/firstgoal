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

    WebDriver Driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(id = "cpn1")
    @CacheLookup
    WebElement CampaignNameField;

    @FindBy(id = "cpn16")
    @CacheLookup
    WebElement ActiveCheckbox;

    @FindBy(id = "cpn2")
    @CacheLookup
    WebElement TypeDropdown;

    @FindBy(id = "cpn5")
    @CacheLookup
    WebElement StartDateField;

    @FindBy(id = "Parent")
    @CacheLookup
    WebElement ParentCampaign;

    @FindBy(id = "Parent_lkgt")
    @CacheLookup
    WebElement LookUpIcon;

    @FindBy(name = "save")
    @CacheLookup
    WebElement SaveButton;

    //endregion

    public NewCampaignForm(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(driver, this);
    }

    public NewCampaignForm setCampaignNameField(String text) {
        CommonActions.setValue(CampaignNameField, text);

        return this;
    }

    public NewCampaignForm checkActiveCheckbox() {
        CommonActions.check(ActiveCheckbox);

        return this;
    }

    public NewCampaignForm selectTypeDropdown(String item) {
        CommonActions.selectItem(TypeDropdown, item);

        return this;
    }

    public NewCampaignForm setStartDateField(String date) {
        CommonActions.setValue(StartDateField, date);

        return this;
    }

    public LookUpWindow clickLookUpIcon() {
        CommonActions.click(LookUpIcon);

        return new LookUpWindow(Driver);
    }

    public CampaignProfile clickSaveButton() {
        CommonActions.click(SaveButton);

        return new CampaignProfile(Driver);
    }
}
