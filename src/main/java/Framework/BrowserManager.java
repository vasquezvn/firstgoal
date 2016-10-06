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

    public WebDriver browser;
    public WebDriverWait waiter;

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
                browser = new FirefoxDriver();
            }
            else if (browserName.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "/src/main/resources/chromedriver");
                browser = new ChromeDriver();
            }
            else {
                System.out.println("incorrect browser");
            }
        }
        catch (WebDriverException wde) {
            System.out.println(wde.getMessage());
        }

    }

    private void configureBrowser() {
        // Maximize browser window
        browser.manage().window().maximize();

        // Set Implicit waits
        browser.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        browser.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
        browser.manage().timeouts().setScriptTimeout(timeout, TimeUnit.SECONDS);

        // Delete Cookies
        browser.manage().deleteAllCookies();

    }

    private void startWait() {
        waiter = new WebDriverWait(browser, timeout);

    }

    public void goStartPage(String url) {
        browser.get(url);

    }
}
