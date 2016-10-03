package Pages.Products;

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
public class ProductProfile {

    WebDriver Driver;
    WebDriverWait wait;

    //region Locators
    @FindBy(name = "del")
    @CacheLookup
    private WebElement deleteBtn;

    @FindBy(name = "edit")
    @CacheLookup
    private WebElement editBtn;

    @FindBy(id = "Name_ileinner")
    @CacheLookup
    private WebElement productNameLabel;

    @FindBy(id = "ProductCode_ileinner")
    @CacheLookup
    private WebElement productCodeLabel;

    @FindBy(id = "Description_ileinner")
    @CacheLookup
    private WebElement productDescriptionLabel;

    @FindBy(id = "IsActive_chkbox")
    @CacheLookup
    private WebElement activeFlagImg;

    @FindBy(id = "Family_ileinner")
    @CacheLookup
    private WebElement productFamilyLabel;

    //endregion

    public ProductProfile(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(driver, this);
    }

    public void pressDeleteBtn() {
        deleteBtn.click();
        Driver.switchTo().alert().accept();
        Driver.switchTo().defaultContent();
    }

    public NewProductForm pressEditBtn() {
        editBtn.click();

        return new NewProductForm(Driver);
    }

    public String getProductName() {
        return productNameLabel.getText();
    }

    public String getProductcode() {
        return productCodeLabel.getText();
    }

    public String getDescription() {
        return productDescriptionLabel.getText();
    }

    public boolean isActiveFlag() {
        boolean result = false;
        String attributeState = activeFlagImg.getAttribute("title");

        if (attributeState.equals("Checked"))
        {
            result = true;
        }

        return result;
    }

    public String getProductFamily() {
        String result = "-None-";

        if (productFamilyLabel.getText().equals("None")) {
            result = productFamilyLabel.getText();
        }

        return result;
    }
}
