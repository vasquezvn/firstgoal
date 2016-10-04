package Scripts;

import Framework.BrowserManager;
import Pages.Accounts.AccountProfile;
import Pages.Accounts.AccountsHome;
import Pages.Accounts.NewAccountForm;
import Pages.Campaigns.CampaignProfile;
import Pages.Campaigns.CampaignsHome;
import Pages.Campaigns.NewCampaignForm;
import Pages.LoginPage;
import Pages.LookUp.LookUpWindow;
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
 * Created by ivan on 2/10/16.
 */
public class CreateOpportunity {

    private TabBar tapBar;
    private LookUpWindow lookUpWindow;

    private OpportunitiesHome opportunitiesHome;
    private NewOpportunityForm newOpportunityForm;
    private OpportunityProfile opportunityProfile;

    private CampaignsHome campaignsHome;
    private NewCampaignForm newCampaignForm;
    private CampaignProfile campaignProfile;

    private AccountsHome accountsHome;
    private NewAccountForm newAccountForm;
    private AccountProfile accountProfile;

    //region values
    private String campaignName;
    private String campaingUrl;

    private String accountName;
    private String accountUrl;

    private String opportunityName = "Opp_name1";
    private String type = "Existing Customer - Replacement";
    private String leadSource = "Partner Referral";
    private String amount = "100";
    private String nextStep = "Conquer the world";
    private String stage = "Needs Analysis";
    private String orderNumber = "00001";
    private String deliveryInstallStatus = "Yet to begin";

    //endregion

    @BeforeTest
    public void BeforeTest() {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("automationqa@test.com")
                .setPasswordField("Control123")
                .clickLoginToSalesForceButton();
        createCampaign();
        createAccount();

    }

    @Test
    public void CreateOpportunity() {
        opportunitiesHome = tapBar
                .clickOpportunityTab();

        newOpportunityForm = opportunitiesHome
                .clickNewButton();

        opportunityProfile = newOpportunityForm
                .checkPrivateFlag(true)
                .setOpportunityName(opportunityName)
                .setAccountName(accountName)
                .chooseTypeDdl(type)
                .chooseLeadSourceDdl(leadSource)
                .setAmount(amount)
                .setCurrentCloseDate()
                .setNextStep(nextStep)
                .chooseStageDdl(stage)
                .setPrimaryCampaignSource(campaignName)
                .setOrderNumber(orderNumber)
                .chooseDeliveryInstallationStatusDdl(deliveryInstallStatus)
                .pressSaveBtn();

        Assert.assertEquals(opportunityProfile.getOpportunityName(), opportunityName);
        Assert.assertEquals(opportunityProfile.getAccountName(), accountName);
        Assert.assertEquals(opportunityProfile.getStage(), stage);
        Assert.assertEquals(opportunityProfile.getOrderNumber(), orderNumber);
        Assert.assertEquals(opportunityProfile.getDeliveryInstallation(), deliveryInstallStatus);

    }

    @AfterTest
    public void afterTest()
    {
        opportunityProfile.pressDeleteBtn();
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

    private void createCampaign() {
        campaignName = "Campaign_" + new Random().nextInt(9999);

        campaignsHome = tapBar
                .clickCampaigns();

        newCampaignForm = campaignsHome
                .clickNewButton();

        campaignProfile = newCampaignForm
                .setCampaignNameField(campaignName)
                .checkActiveCheckbox()
                .clickSaveButton();

        campaingUrl = campaignProfile.getUrl();

    }
}
