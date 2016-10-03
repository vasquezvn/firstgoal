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
public class ContactsHome {

    WebDriver Driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(xpath = "//input[@name='new']")
    @CacheLookup
    WebElement newButton;

    //endregion

    public ContactsHome(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(driver, this);
    }

    public NewContactForm clickNewButton() {
        CommonActions.click(newButton);

        return new NewContactForm(Driver);
    }
}
