package Pages.LookUp;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Campaigns.NewCampaignForm;
import Pages.Opportunities.NewOpportunityForm;
import com.sun.corba.se.spi.activation.ServerAlreadyRegisteredHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.debugger.Page;

import java.util.LinkedList;

/**
 * Created by ivan on 17/9/16.
 */
public class LookUpWindow {

    WebDriver driver;
    WebDriverWait wait;

    String PreviousWindow;
    String LookUpWindow;

    // region Locators
    @FindBy(xpath = "//div[@class='pBody']/select")
    @CacheLookup
    WebElement searchWithinDropdown;

    @FindBy(xpath = "//div[@class='pBody']/input[@type='text']")
    @CacheLookup
    WebElement searchField;

    @FindBy(xpath = "//div[@class='pBody']/input[@class='btn' and @type='submit']")
    @CacheLookup
    WebElement goButton;

    @FindBy(className = "dataRow even last first")
    @CacheLookup
    WebElement rowsContaine;

    @FindBy(id = "searchFrame")
    @CacheLookup
    WebElement searchFrame;

    @FindBy(id = "resultsFrame")
    @CacheLookup
    WebElement searchResultFrame;

    // endregion

    public LookUpWindow(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;
        PageFactory.initElements(this.driver, this);

        String LookUpWindown = new LinkedList(driver.getWindowHandles()).getLast().toString();
        driver.switchTo().window(LookUpWindow);
    }

    public LookUpWindow selectSerachWithinDropdown(String item) {
        CommonActions.selectItem(searchWithinDropdown, item);

        return this;
    }

    public LookUpWindow setSearchWithinField(String text) {
        CommonActions.setValue(searchField, text);

        return this;
    }

    public LookUpWindow clickGoButton() {
        CommonActions.click(goButton);

        return this;
    }

    public NewCampaignForm clickResult(String text) {
        CommonActions.click(rowsContaine.findElement(By.xpath("//a[contains(., '"
                + text +"')]")));
        driver.switchTo().defaultContent();

        return new NewCampaignForm(driver);
    }

    public NewOpportunityForm clickResultGotoNewOpportunityForm(String text) {
        CommonActions.click(rowsContaine.findElement(By.xpath("//a[contains(.,'" +
                text + "')]")));
        driver.switchTo().defaultContent();

        return new NewOpportunityForm(driver);
    }


    public LookUpWindow switchSearchFrame() {
        driver.switchTo().frame(searchFrame);

        return this;
    }

    public LookUpWindow switchResultFrame() {
        driver.switchTo().frame(searchResultFrame);

        return this;
    }
}
