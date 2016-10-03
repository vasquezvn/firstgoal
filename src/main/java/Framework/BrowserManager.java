package Framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by ivan on 1/9/16.
 */
public class BrowserManager {

    private static BrowserManager instance;

    public WebDriver Browser;
    public WebDriverWait Waiter;

    private int timeout = 30;

    private BrowserManager() {
        openBrowser("Firefox");
        configureBrowser();

    }

    public static BrowserManager getInstance() {
        if (instance == null) {
            instance = new BrowserManager();

        }

        return instance;
    }

    private void openBrowser(String browserName) {
        try {
            if (browserName.equalsIgnoreCase("Firefox")) {
                Browser = new FirefoxDriver();
            }
            else if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "/src/main/resources/chromedriver");
                Browser = new ChromeDriver();
            }
            else {
                System.out.println("incorrect Browser");
            }
        }
        catch (WebDriverException wde) {
            System.out.println(wde.getMessage());
        }

    }

    private void configureBrowser() {
        // Maximize Browser window
        Browser.manage().window().maximize();

        // Set Implicit waits
        Browser.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        Browser.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        Browser.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);

        // Delete Cookies
        Browser.manage().deleteAllCookies();

    }

    private void startWait() {
        Waiter = new WebDriverWait(Browser, timeout);

    }

    public void goStartPage(String url) {
        Browser.get(url);

    }
}
