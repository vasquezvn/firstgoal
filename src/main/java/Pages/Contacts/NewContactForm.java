package Pages.Contacts;

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
 * Created by ivan on 2/10/16.
 */
public class NewContactForm {

    WebDriver Driver;
    WebDriverWait wait;


    // region Locators
    @FindBy(id="name_salutationcon2")
    @CacheLookup
    WebElement firstnameCategoryField;

    @FindBy(id="name_firstcon2")
    @CacheLookup
    WebElement firstNameField;

    @FindBy(id="name_lastcon2")
    @CacheLookup
    WebElement lastNameField;

    @FindBy(id="con4")
    @CacheLookup
    WebElement accountNameField;

    @FindBy(id="con5")
    @CacheLookup
    WebElement titleField;

    @FindBy(id="con6")
    @CacheLookup
    WebElement departmentField;

    @FindBy(id="con7")
    @CacheLookup
    WebElement birthDateField;

    @FindBy(id="con8")
    @CacheLookup
    WebElement reportToField;

    @FindBy(id="con9")
    @CacheLookup
    WebElement leadSourceField;

    @FindBy(id="con10")
    @CacheLookup
    WebElement phoneField;

    @FindBy(xpath="//input[@tabindex='31']")
    @CacheLookup
    WebElement saveBtn;

    @FindBy(xpath="//input[@tabindex='32']")
    @CacheLookup
    WebElement saveNewBtn;

    @FindBy(xpath="//input[@tabindex='33']")
    @CacheLookup
    WebElement cancelBtn;

    // endregion

    public NewContactForm(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(driver, this);
    }

    public NewContactForm selectFirstNameCategory(String item) {
        CommonActions.selectItem(firstnameCategoryField, item);

        return this;
    }

    public NewContactForm setContactNameField(String text) {
        CommonActions.setValue(firstNameField, text);

        return this;
    }

    public NewContactForm setLastName(String text) {
        CommonActions.setValue(lastNameField, text);

        return this;
    }

    public NewContactForm setAccountName(String text) {
        CommonActions.setValue(accountNameField, text);

        return this;
    }

    public NewContactForm setTitle(String text) {
        CommonActions.setValue(titleField, text);

        return this;
    }

    public NewContactForm setDepartment(String text) {
        CommonActions.setValue(departmentField, text);

        return this;
    }

    public NewContactForm setBirthDate(String date) {
        CommonActions.setValue(birthDateField, date);

        return this;
    }

    public LookUpWindow clickReportTo() {
        CommonActions.click(reportToField);

        return new LookUpWindow(Driver);
    }

    public NewContactForm selectLeadSource(String item) {
        CommonActions.selectItem(leadSourceField, item);

        return this;
    }

    public ContactsProfile clickSaveButton() {
        CommonActions.click(saveBtn);

        return new ContactsProfile(Driver);
    }


}
