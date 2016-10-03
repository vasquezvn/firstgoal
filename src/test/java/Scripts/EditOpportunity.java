package Scripts;

import Framework.BrowserManager;
import Pages.LoginPage;
import Pages.Opportunities.NewOpportunityForm;
import Pages.Opportunities.OpportunitiesHome;
import Pages.Opportunities.OpportunityProfile;
import Pages.TopBar.TabBar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ivan on 3/10/16.
 */
public class EditOpportunity {

    TabBar tapBar;
    OpportunitiesHome opportunitiesHome;
    NewOpportunityForm newOpportunityForm;
    OpportunityProfile opportunityProfile;

    //region values
    private boolean isPrivate = true;
    private String opportunityName = "Opp_name1";
    private String opportunityNameUpdate = "Opp_name2";
    private String accountName = "test account_1";
    private String accountNameUpdate = "test account_2";
    private String stage = "Needs Analysis";
    private String stageUpdate = "Perception Analysis";
    //endregion

    @Before
    public void BeforeTest() {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("automationqa@test.com")
                .setPasswordField("Control123")
                .clickLoginToSalesForceButton();

        createOpportunity();
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

    @Test
    public void EditOpportunity()
    {
        newOpportunityForm = opportunityProfile
                .pressEditBtn();

        opportunityProfile = newOpportunityForm
                .uncheckPrivateFlag(isPrivate)
                .setOpportunityName(opportunityNameUpdate)
                .setAccountName(accountNameUpdate)   // TODO: lookup
                .chooseStageDdl(stageUpdate)
                .pressSaveBtn();

        Assert.assertEquals(opportunityProfile.isPrivateFlag(), false);
        Assert.assertEquals(opportunityProfile.getOpportunityName(), opportunityNameUpdate);
        Assert.assertEquals(opportunityProfile.getAccountName(), accountNameUpdate);
        Assert.assertEquals(opportunityProfile.getStage(), stageUpdate);
    }

    @After
    public void afterTest()
    {
        opportunityProfile.pressDeleteBtn();
    }
}
