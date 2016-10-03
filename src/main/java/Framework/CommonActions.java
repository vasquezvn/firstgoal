package Framework;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by ivan on 1/9/16.
 */
public class CommonActions {

    public static void click(WebElement element) {
        element.click();

    }

    public static void setValue(WebElement element, String text) {
        element.sendKeys(text);

    }

    public static void selectItem(WebElement element, String item) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(item);

    }

    public static void check(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }

    }

    public static void clickAcceptAlert(WebElement element, WebDriver driver) {
        element.click();
        Alert javascriptAlert = driver.switchTo().alert();
        javascriptAlert.accept();
        driver.switchTo().defaultContent();

    }
}
