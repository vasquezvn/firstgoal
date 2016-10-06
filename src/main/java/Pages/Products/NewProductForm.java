package Pages.Products;

import Framework.BrowserManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 2/10/16.
 */
public class NewProductForm {

    WebDriver driver;
    WebDriverWait wait;

    //region Locators
    @FindBy(name = "save")
    @CacheLookup
    WebElement saveBtn;

    @FindBy(id = "Name")
    @CacheLookup
    WebElement productNameTextbox;

    @FindBy(id = "ProductCode")
    @CacheLookup
    WebElement productCodeTextbox;

    @FindBy(id = "IsActive")
    @CacheLookup
    WebElement activeFlag;

    @FindBy(id = "Family")
    @CacheLookup
    WebElement multiSelectProductFamily;

    @FindBy(id = "Description")
    @CacheLookup
    WebElement descriptionTextArea;

    //endregion

    public NewProductForm(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);
    }

    public NewProductForm setProductName(String productName) {
        productNameTextbox.clear();
        productNameTextbox.sendKeys(productName);

        return this;
    }

    public NewProductForm checkActiveFlag(boolean flag) {
        if (!activeFlag.isSelected() && flag) {
            activeFlag.click();
        }

        return this;
    }

    public NewProductForm uncheckActiveFlag(boolean flag) {
        if (activeFlag.isSelected() && flag) {
            activeFlag.click();
        }

        return this;
    }

    public NewProductForm setProductCode(String productCode) {
        productCodeTextbox.clear();
        productCodeTextbox.sendKeys(productCode);

        return this;
    }

    public NewProductForm chooseProductFamilyDdl(String productFamily) {
        Select selectBox = new Select(multiSelectProductFamily);

        if (productFamily.equals("")) {
            selectBox.selectByIndex(0);
        } else {
            selectBox.selectByVisibleText(productFamily);
        }

        return this;
    }

    public NewProductForm setDescription(String description) {
        descriptionTextArea.clear();
        descriptionTextArea.sendKeys(description);

        return this;
    }

    public ProductProfile pressSaveBtn() {
        saveBtn.click();

        return new ProductProfile(driver);
    }
}
