import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
//    public static WebDriver driver;

    public void hoverToElement(WebElement element){
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public WebElement waitVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

}
