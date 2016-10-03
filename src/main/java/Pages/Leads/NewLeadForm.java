package Pages.Leads;

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
public class NewLeadForm {

    WebDriver Driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(id = "name_lastlea2")
    @CacheLookup
    WebElement lastNameField;

    @FindBy(id = "lea13")
    @CacheLookup
    WebElement leadStatusField;

    @FindBy(id = "lea3")
    @CacheLookup
    WebElement companyField;

    @FindBy(id = "name_firstlea2")
    @CacheLookup
    WebElement firstNameField;

    @FindBy(id = "lea16street")
    @CacheLookup
    WebElement streetField;

    @FindBy(id = "lea16city")
    @CacheLookup
    WebElement leadCityField;

    @FindBy(name = "save")
    @CacheLookup
    WebElement SaveButton;

    // endregion

    public NewLeadForm(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(driver, this);
    }

    public NewLeadForm setLastNameField(String text) {
        CommonActions.setValue(lastNameField, text);

        return this;
    }


    public NewLeadForm setStatusField(String text) {
        CommonActions.setValue(leadStatusField, text);

        return this;
    }

    public NewLeadForm setCompanyField(String text){
        CommonActions.setValue(companyField, text);

        return this;
    }

    public NewLeadForm setFirstNameField(String text){
        CommonActions.setValue(firstNameField, text);

        return this;
    }

    public NewLeadForm setStreetField(String text){
        CommonActions.setValue(streetField, text);

        return this;
    }

    public NewLeadForm setLeadCityField(String text){
        CommonActions.setValue(leadCityField, text);

        return this;
    }

    public LeadProfile clickSaveButton() {
        CommonActions.click(SaveButton);

        return new LeadProfile(Driver);
    }
}
