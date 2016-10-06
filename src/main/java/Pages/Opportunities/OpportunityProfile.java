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
public class OpportunityProfile {

    WebDriver driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(name = "del")
    @CacheLookup
    WebElement deleteBtn;

    @FindBy(name = "edit")
    @CacheLookup
    WebElement editBtn;

    @FindBy(id = "opp3_ileinner")
    @CacheLookup
    WebElement opportunityNameLabel;

    @FindBy(id = "opp4_ileinner")
    @CacheLookup
    WebElement accountNameLabel;

    @FindBy(id = "opp9_ileinner")
    @CacheLookup
    WebElement closeDateLabel;

    @FindBy(id = "opp11_ileinner")
    @CacheLookup
    WebElement stageLabel;

    @FindBy(xpath = "//td[contains(., 'Order Number')]/following::div")
    @CacheLookup
    WebElement orderNumberLabel;

    @FindBy(xpath = "//td[contains(., 'Delivery/Installation Status')]/following::div")
    @CacheLookup
    WebElement deliveryInstallLabel;

    @FindBy(id = "opp2_chkbox")
    @CacheLookup
    WebElement privateFlagImg;

    // endregion

    public OpportunityProfile(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);
    }

    public void pressDeleteBtn() {  CommonActions.clickAcceptAlert(deleteBtn, driver);  }

    public NewOpportunityForm pressEditBtn() {
        CommonActions.click(editBtn);

        return new NewOpportunityForm(driver);
    }

    public boolean isPrivateFlag() {
        boolean result = false;
        String attributeState = privateFlagImg.getAttribute("title");

        if (attributeState.equals("Checked")) {
            result = true;

        }

        return result;
    }

    public String getOpportunityName() {
        return opportunityNameLabel.getText();
    }

    public String getAccountName() {
        return accountNameLabel.getText();
    }

    public String getCloseDate() {
        return closeDateLabel.getText();
    }

    public String getStage() {
        return stageLabel.getText();
    }

    public String getOrderNumber() {
        return orderNumberLabel.getText();
    }

    public String getDeliveryInstallation() {
        return deliveryInstallLabel.getText();
    }


}
