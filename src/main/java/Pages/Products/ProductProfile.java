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

    WebDriver driver;
    WebDriverWait wait;

    //region Locators
    @FindBy(name = "del")
    @CacheLookup
    WebElement deleteBtn;

    @FindBy(name = "edit")
    @CacheLookup
    WebElement editBtn;

    @FindBy(id = "Name_ileinner")
    @CacheLookup
    WebElement productNameLabel;

    @FindBy(id = "ProductCode_ileinner")
    @CacheLookup
    WebElement productCodeLabel;

    @FindBy(id = "Description_ileinner")
    @CacheLookup
    WebElement productDescriptionLabel;

    @FindBy(id = "IsActive_chkbox")
    @CacheLookup
    WebElement activeFlagImg;

    @FindBy(id = "Family_ileinner")
    @CacheLookup
    WebElement productFamilyLabel;

    //endregion

    public ProductProfile(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);
    }

    public void pressDeleteBtn() {
        deleteBtn.click();
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();

    }

    public NewProductForm pressEditBtn() {
        editBtn.click();

        return new NewProductForm(driver);
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

        if (attributeState.equals("Checked")) {
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
