package Scripts;

import Framework.BrowserManager;
import Pages.Contacts.ContactsHome;
import Pages.Contacts.ContactsProfile;
import Pages.Contacts.NewContactForm;
import Pages.LoginPage;
import Pages.LookUp.LookUpWindow;
import Pages.TopBar.TabBar;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ivan on 2/10/16.
 */
public class CreateContact {

    TabBar tapBar;
    ContactsHome contactsHome;
    NewContactForm newContactForm;
    LookUpWindow lookUpWindow;
    ContactsProfile contactsProfile;


    @Before
    public void BeforeTest() {
        BrowserManager.getInstance().goStartPage("https://login.salesforce.com/");
        tapBar = new LoginPage()
                .setUserNameField("automationqa@test.com")
                .setPasswordField("Control123")
                .clickLoginToSalesForceButton();

    }

    @Test
    public void CreateContact() {
        contactsHome = tapBar.clickContacts();

        newContactForm = contactsHome
                .clickNewButton();

        newContactForm.selectFirstNameCategory("Prof.")
                .setContactNameField("Test100")
                .setLastName("TestLastName100")
                .setTitle("TestTitle100")
                .setDepartment("TestDepartment100");

        contactsProfile = newContactForm
                .clickSaveButton();

        String contactName = contactsProfile.getContactNameLabel();
        Assert.assertEquals(contactName, "Prof. Test100 TestLastName100");
        contactsProfile.getContactNameLabel();

    }

    @After
    public void AfterTest() {
        contactsProfile.deleteContact();

    }

}
