import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskCCartPage extends BasePage{
    private final WebDriver driver;

    public TaskCCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By positionInTheList = By.xpath("");

    public TaskCCartPage checkingProductInTheCart(){

        return this;
    }
}
