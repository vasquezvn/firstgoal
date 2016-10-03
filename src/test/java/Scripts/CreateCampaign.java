package Scripts;

import Framework.BrowserManager;
import Pages.Campaigns.CampaignProfile;
import Pages.Campaigns.CampaignsHome;
import Pages.Campaigns.NewCampaignForm;
import Pages.LoginPage;
import Pages.LookUp.LookUpWindow;
import Pages.TopBar.TabBar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

/**
 * Created by ivan on 18/9/16.
 */
public class CreateCampaign {

    TabBar tabBar;
    CampaignsHome campaignsHome;
    NewCampaignForm newCampaignForm;
    LookUpWindow lookUpWindow;
    CampaignProfile campaignProfile;

    String campaignParent;
    String campaignParantUrl;

    @Before
    public void Before() {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");

        tabBar = new LoginPage()
                .setUserNameField("automationqa@test.com")
                .setPasswordField("Control123")
                .clickLoginToSalesForceButton();

        campaignParent = "Parent" + new Random().nextInt(9999);
        campaignsHome = tabBar
                .clickCampaigns();

        newCampaignForm = campaignsHome
                .clickNewButton();

        campaignProfile = newCampaignForm
                .setCampaignNameField(campaignParent)
                .checkActiveCheckbox()
                .clickSaveButton();

        campaignParantUrl = campaignProfile.getUrl();
    }

    @Test
    public void CreateCampaign() {
        campaignsHome = tabBar
                .clickCampaigns();

        newCampaignForm = campaignsHome
                .clickNewButton();

        lookUpWindow = newCampaignForm
                .setCampaignNameField("Test00100")
                .checkActiveCheckbox()
                .selectTypeDropdown("Email")
                .setStartDateField("6/24/2015")
                .clickLookUpIcon();

        newCampaignForm = lookUpWindow
                .switchSearchFrame()
                .setSearchWithinField(campaignParent)
                .clickGoButton()
                .switchResultFrame()
                .clickResult(campaignParent);

        campaignProfile = newCampaignForm
                .clickSaveButton();

        String campaingName = campaignProfile.getCampaignNameLabel();

        Assert.assertEquals(campaingName, "Test00100");

    }

    @After
    public void afterTest() {
        campaignsHome = campaignProfile
                .clickDeleteButton();

        campaignProfile = campaignsHome
                .goCampaingProfile(campaignParantUrl);

        campaignsHome = campaignProfile
                .clickDeleteButton();

    }

}
