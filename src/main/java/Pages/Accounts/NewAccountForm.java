package Pages.Accounts;

import Framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 2/10/16.
 */
public class NewAccountForm {

    WebDriver driver;
    WebDriverWait wait;

    //region Locators
    @FindBy(id = "acc2")
    @CacheLookup
    WebElement accountNameTextbox;

    @FindBy(name = "save")
    @CacheLookup
    WebElement saveBtn;
    //endregion

    public NewAccountForm(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);
    }

    public NewAccountForm setAccountName(String accountName) {
        accountNameTextbox.clear();
        accountNameTextbox.sendKeys(accountName);

        return this;
    }

    public AccountProfile pressSaveBtn() {
        saveBtn.click();

        return new AccountProfile(driver);
    }
}
