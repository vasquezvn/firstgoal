package Pages.Products;

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
public class ProductsHome {

    WebDriver Driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(xpath = "//*[@name='new' and @type='button']")
    @CacheLookup
    WebElement NewButtton;

    // endregion

    public ProductsHome(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(Driver, this);
    }

    public NewProductForm clickNewButton() {
        CommonActions.click(NewButtton);

        return new NewProductForm(Driver);
    }
}