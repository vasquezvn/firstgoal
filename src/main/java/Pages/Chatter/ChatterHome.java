package Pages.Chatter;

import Framework.BrowserManager;
import Framework.CommonActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by ivan on 2/10/16.
 */
public class ChatterHome {

    WebDriver driver;
    WebDriverWait wait;

    //region Locators
    @FindBy(xpath = "//textarea[@id='publishereditablearea']")
    @CacheLookup
    WebElement publisheredArea;

    @FindBy(id = "publishersharebutton")
    @CacheLookup
    WebElement shareButton;

    @FindBy(xpath = "//a[@onclick='chatter.getFeed().showCommentBoxViaAnchor(this);']")
    @CacheLookup
    WebElement commentLink;

    @FindBy(xpath = "//textarea[@data-uidsfdc='126']")
    @CacheLookup
    WebElement commentText;

    @FindBy(xpath = "//input[contains(@id,'ext-gen8')]")
    @CacheLookup
    WebElement commentButton;


    public ChatterHome(WebDriver driver) {
        this.driver = driver;
        wait = BrowserManager.getInstance().waiter;

        PageFactory.initElements(this.driver, this);
    }

    public ChatterHome setPubliSheredArea(String text) {
        CommonActions.setValue(publisheredArea, text);

        return this;
    }

    public ChatterHome clickPostButton() {
        CommonActions.click(shareButton);

        return this;
    }

    public ChatterHome clickCommentLink() {
        CommonActions.click(commentLink);

        return this;
    }

    public ChatterHome setPCommentText(String text) {
        CommonActions.setValue(commentText, text);

        return this;
    }

    public ChatterHome clickCommentButton() {
        CommonActions.click(commentButton);

        return this;
    }
}
