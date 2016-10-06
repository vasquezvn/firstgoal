package Pages.Contacts;

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
public class ContactsProfile {

    WebDriver driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(className = "topName")
    @CacheLookup
    WebElement contactNameLabel;

    @FindBy(xpath = "//input[@name='del']")
    @CacheLookup
    WebElement deleteButton;

    @FindBy(xpath = "//input[@name='edit']")
    @CacheLookup
    private WebElement editButton;

    // endregion

    public ContactsProfile(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);
    }

    public String getContactNameLabel() {  return contactNameLabel.getText(); }

    public void deleteContact() {  CommonActions.clickAcceptAlert(deleteButton, driver);  }

    public NewContactForm clickEditForm() {
        CommonActions.click(editButton);

        return new NewContactForm(driver);
    }
}
