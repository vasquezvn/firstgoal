package Pages.Opportunities;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.LookUp.LookUpWindow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

/**
 * Created by ivan on 2/10/16.
 */
public class NewOpportunityForm {

    WebDriver driver;
    WebDriverWait wait;

    // to manage window popup
    String mainWindowId;
    Set<String> windows;

    // region Locators
    @FindBy(name = "save")
    @CacheLookup
    WebElement saveBtn;

    @FindBy(id = "opp2")
    @CacheLookup
    WebElement privateFlag;

    @FindBy(id = "opp3")
    @CacheLookup
    WebElement opportunityNameTextBox;

    @FindBy(id = "opp4")
    @CacheLookup
    WebElement accountNameTextBox;

    @FindBy(xpath = "//img=[@alt='Account name Lookup (New Window)']")
    @CacheLookup
    WebElement accountNameLookupIconBtn;

    @FindBy(id = "opp5")
    @CacheLookup
    WebElement multiSelectType;

    @FindBy(id = "opp6")
    @CacheLookup
    WebElement multiSelectLeadSource;

    @FindBy(id = "opp7")
    @CacheLookup
    WebElement amountTextBox;

    @FindBy(id = "opp9")
    @CacheLookup
    WebElement closeDateTextBox;

    @FindBy(xpath = "//input[@id='opp9']/following::a")
    @CacheLookup
    WebElement todayLink;

    @FindBy(id = "opp10")
    @CacheLookup
    WebElement nextStepTextBox;

    @FindBy(id = "opp11")
    @CacheLookup
    WebElement multiSelectStage;

    @FindBy(id = "opp12")
    @CacheLookup
    WebElement probabilityTextBox;

    @FindBy(id = "opp17")
    @CacheLookup
    WebElement primaryCampaingSourceTextBox;

    @FindBy(xpath = "//img[@alt='Primary Campaign Source Lookup (New Window)']")
    @CacheLookup
    WebElement primaryCampaignSourceLookupIconBtn;

    @FindBy(xpath = "//td[contains(., 'Order Number')]/following::input")
    @CacheLookup
    WebElement ordernumberTextBox;

    @FindBy(xpath = "//td[contains(., 'Delivery')]/following::span/select")
    @CacheLookup
    WebElement multiSelectDeliveryinstallationStatus;

    @FindBy(id = "opp14")
    @CacheLookup
    WebElement descriptionTextArea;

    // endregion

    public NewOpportunityForm(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;
        mainWindowId = driver.getWindowHandle();

        PageFactory.initElements(this.driver, this);
    }

    public NewOpportunityForm checkPrivateFlag(boolean flag) {
        CommonActions.check(privateFlag);

        return this;
    }

    public NewOpportunityForm uncheckPrivateFlag(boolean flag) {

        if (privateFlag.isSelected() && flag) {
            privateFlag.click();
        }

        return this;
    }

    public NewOpportunityForm setOpportunityName(String opportunityName) {
        CommonActions.setValue(opportunityNameTextBox, opportunityName);

        return this;
    }

    public NewOpportunityForm setAccountName(String accountName) {
        CommonActions.setValue(accountNameTextBox, accountName);

        return this;
    }

    public NewOpportunityForm chooseTypeDdl(String type) {
        CommonActions.selectItem(multiSelectType, type);

        return this;
    }

    public NewOpportunityForm chooseLeadSourceDdl(String leadSource) {
        Select selectBox = new Select(multiSelectLeadSource);
        selectBox.selectByVisibleText(leadSource);

        return this;
    }

    public NewOpportunityForm setAmount(String amount) {
        CommonActions.setValue(amountTextBox, amount);

        return this;
    }

    public NewOpportunityForm setCloseDate(String closeDate) {
        CommonActions.setValue(closeDateTextBox, closeDate);

        return this;
    }

    public NewOpportunityForm setCurrentCloseDate() {
        closeDateTextBox.clear();
        todayLink.click();

        return this;
    }

    public NewOpportunityForm setNextStep(String nextStep) {
        CommonActions.setValue(nextStepTextBox, nextStep);

        return this;
    }

    public NewOpportunityForm chooseStageDdl(String stage) {
        CommonActions.selectItem(multiSelectStage, stage);

        return this;
    }

    public NewOpportunityForm setProbability(String probability) {
        CommonActions.setValue(nextStepTextBox, probability);

        return this;
    }

    public NewOpportunityForm setPrimaryCampaignSource(String primaryCampaignSource) {
        CommonActions.setValue(primaryCampaingSourceTextBox, primaryCampaignSource);

        return this;
    }

    public NewOpportunityForm setOrderNumber(String orderNumber) {
        CommonActions.setValue(ordernumberTextBox, orderNumber);

        return this;
    }

    public NewOpportunityForm chooseDeliveryInstallationStatusDdl(String status) {
        CommonActions.selectItem(multiSelectDeliveryinstallationStatus, status);

        return this;
    }

    public NewOpportunityForm setDescription(String description) {
        CommonActions.setValue(descriptionTextArea, description);

        return this;
    }

    public OpportunityProfile pressSaveBtn() {
        saveBtn.click();

        return new OpportunityProfile(driver);
    }

    public LookUpWindow clickAccountNameLookUpIcon() {
        CommonActions.click(accountNameLookupIconBtn);

        return new LookUpWindow(driver);
    }

    public LookUpWindow clickPrimaryCampaignSrcLookUpIcon() {
        CommonActions.click(primaryCampaignSourceLookupIconBtn);

        return new LookUpWindow(driver);
    }
}
