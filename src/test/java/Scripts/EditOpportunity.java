package Scripts;

import Framework.BrowserManager;
import Pages.Accounts.AccountProfile;
import Pages.Accounts.AccountsHome;
import Pages.Accounts.NewAccountForm;
import Pages.LoginPage;
import Pages.Opportunities.NewOpportunityForm;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Opportunities.OpportunityProfile;
import Pages.TopBar.TabBar;
import org.junit.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;

/**
 * Created by ivan on 3/10/16.
 */
public class EditOpportunity {

    TabBar tapBar;
    OpportunitiesHome opportunitiesHome;
    NewOpportunityForm newOpportunityForm;
    OpportunityProfile opportunityProfile;

    //region values
    private AccountsHome accountsHome;
    private NewAccountForm newAccountForm;
    private AccountProfile accountProfile;
    private String accountUrl;

    private boolean isPrivate = true;
    private String opportunityName = "Opp_name";
    private String opportunityNameUpdate = "Opp_name_UPDATED";
    private String accountName;
    private String stage = "Needs Analysis";
    private String stageUpdate = "Perception Analysis";
    //endregion

    @BeforeTest
    public void BeforeTest() {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("automationqa@test.com")
                .setPasswordField("Control123")
                .clickLoginToSalesForceButton();

        createAccount();
        createOpportunity();
    }

    @Test
    public void EditOpportunity() {
        newOpportunityForm = opportunityProfile
                .pressEditBtn();

        opportunityProfile = newOpportunityForm
                .uncheckPrivateFlag(isPrivate)
                .setOpportunityName(opportunityNameUpdate)
                .chooseStageDdl(stageUpdate)
                .pressSaveBtn();

        Assert.assertEquals(opportunityProfile.isPrivateFlag(), false);
        Assert.assertEquals(opportunityProfile.getOpportunityName(), opportunityNameUpdate);
        Assert.assertEquals(opportunityProfile.getStage(), stageUpdate);
    }

    @AfterTest
    public void afterTest()
    {
        opportunityProfile.pressDeleteBtn();
    }

    private void createOpportunity() {
        opportunitiesHome = tapBar
                .clickOpportunityTab();

        newOpportunityForm = opportunitiesHome
                .clickNewButton();

        opportunityProfile = newOpportunityForm
                .checkPrivateFlag(isPrivate)
                .setOpportunityName(opportunityName)
                .setAccountName(accountName)   // TODO: lookup
                .setCurrentCloseDate()
                .chooseStageDdl(stage)
                .pressSaveBtn();
    }

    private void createAccount() {
        accountName = "Account_" + new Random().nextInt(9999);

        accountsHome = tapBar
                .clickAccountsTab();

        newAccountForm = accountsHome
                .clickNewButton();

        accountProfile = newAccountForm
                .setAccountName(accountName)
                .pressSaveBtn();

        accountUrl = accountProfile.getUrl();

    }
}
