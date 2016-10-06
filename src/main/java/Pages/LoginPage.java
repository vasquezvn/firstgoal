package Pages;

import Framework.BrowserManager;
import Pages.TopBar.TabBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 10/9/16.
 */
public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(id = "username")
    @CacheLookup
    WebElement userNameFiLogield;

    @FindBy(id = "password")
    @CacheLookup
    WebElement passwordTxt;

    @FindBy(id = "Login")
    @CacheLookup
    WebElement loginField;

    //endregion

    public LoginPage() {
        driver = BrowserManager.getInstance().browser;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(driver, this);
    }

    public LoginPage setUserNameField(String email) {
        userNameFiLogield.clear();
        userNameFiLogield.sendKeys(email);

        return this;
    }

    public LoginPage setPasswordField(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public TabBar clickLoginToSalesForceButton() {
        loginField.click();

        return new TabBar(driver);
    }


}
