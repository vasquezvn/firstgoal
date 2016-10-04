package Pages.TopBar;

import Framework.BrowserManager;
import Framework.CommonActions;
import Pages.Accounts.AccountsHome;
import Pages.Campaigns.CampaignsHome;
import Pages.Chatter.ChatterHome;
import Pages.Contacts.ContactsHome;
import Pages.Leads.LeadsHome;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Products.ProductsHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 18/9/16.
 */
public class TabBar {

    WebDriver Driver;
    WebDriverWait wait;

    // region Locators
    @FindBy(xpath = "//*[@id='Campaign_Tab']/*[contains(.,'Campañas')]")
    @CacheLookup
    WebElement CampaignsTab;

    @FindBy(xpath = "//*[@id='Opportunity_Tab']/*[contains(.,'Oportunidades')]")
    @CacheLookup
    WebElement opportunitiesTab;

    @FindBy(xpath = "//*[@id='Product2_Tab']/*[contains(.,'Productos')]")
    @CacheLookup
    WebElement productsTab;

    @FindBy(xpath = "//*[@id='Account_Tab']/*[contains(.,'Cuentas')]")
    @CacheLookup
    WebElement accountTab;

    @FindBy(xpath = "//a[@title='Ficha Candidatos']")
    @CacheLookup
    WebElement LeadTab;

    @FindBy(xpath = "//a[@href='/003/o']")
    @CacheLookup
    WebElement contactsTab;

    @FindBy(xpath = "//a[@href='/_ui/core/chatter/ui/ChatterPage']")
    @CacheLookup
    WebElement chatterTab;

    // endregion

    public TabBar(WebDriver driver) {
        Driver = driver;
        wait = BrowserManager.getInstance().Waiter;

        PageFactory.initElements(driver, this);
    }

    public CampaignsHome clickCampaigns() {
        CommonActions.click(CampaignsTab);

        return new CampaignsHome(Driver);
    }

    public ContactsHome clickContacts() {
        CommonActions.click(contactsTab);
        return new ContactsHome(Driver);
    }

    public OpportunitiesHome clickOpportunityTab() {
        CommonActions.click(opportunitiesTab);

        return new OpportunitiesHome(Driver);
    }

    public ProductsHome clickProductsTab() {
        CommonActions.click(productsTab);

        return new ProductsHome(Driver);
    }

    public AccountsHome clickAccountsTab() {
        CommonActions.click(accountTab);

        return new AccountsHome(Driver);
    }

    public LeadsHome clickLead() {
        CommonActions.click(LeadTab);
        return new LeadsHome(Driver);
    }

    public ChatterHome clickChatter() {
        CommonActions.click(chatterTab);
        return new ChatterHome(Driver);
    }
}
