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

    WebDriver Driver;
    WebDriverWait wait;

    String PreviousWindow;
    String LookUpWindow;

    // region Locators
    @FindBy(xpath = "//div[@class='pBody']/select")
    @CacheLookup
    WebElement SearchWithinDropdown;

    @FindBy(xpath = "//div[@class='pBody']/input[@type='text']")
    @CacheLookup
    WebElement SearchField;

    @FindBy(xpath = "//div[@class='pBody']/input[@class='btn' and @type='submit']")
    @CacheLookup
    WebElement GoButton;

    @FindBy(className = "dataRow even last first")
    @CacheLookup
    WebElement RowsContaine;

    @FindBy(id = "searchFrame")
    @CacheLookup
    WebElement SearchFrame;

    @FindBy(id = "resultsFrame")
    @CacheLookup
    WebElement SearchResultFrame;

    // endregion

    public LookUpWindow(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;
        PageFactory.initElements(driver, this);

        String LookUpWindown = new LinkedList(driver.getWindowHandles()).getLast().toString();
        Driver.switchTo().window(LookUpWindow);
    }

    public LookUpWindow selectSerachWithinDropdown(String item) {
        CommonActions.selectItem(SearchWithinDropdown, item);

        return this;
    }

    public LookUpWindow setSearchWithinField(String text) {
        CommonActions.setValue(SearchField, text);

        return this;
    }

    public LookUpWindow clickGoButton() {
        CommonActions.click(GoButton);

        return this;
    }

    public NewCampaignForm clickResult(String text) {
        CommonActions.click(RowsContaine.findElement(By.xpath("//a[contains(., '"
                + text +"')]")));
        Driver.switchTo().defaultContent();

        return new NewCampaignForm(Driver);
    }

    public NewOpportunityForm clickResultGotoNewOpportunityForm(String text) {
        CommonActions.click(RowsContaine.findElement(By.xpath("//a[contains(.,'" +
                text + "')]")));
        Driver.switchTo().defaultContent();

        return new NewOpportunityForm(Driver);
    }


    public LookUpWindow switchSearchFrame() {
        Driver.switchTo().frame(SearchFrame);

        return this;
    }

    public LookUpWindow switchResultFrame() {
        Driver.switchTo().frame(SearchResultFrame);

        return this;
    }
}
