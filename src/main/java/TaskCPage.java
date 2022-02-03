import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TaskCPage extends BasePage {
    private final WebDriver driver;

    public TaskCPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By tShirtToAdd = By.xpath("");
    private final By colorDropDown = By.xpath("");
    private final By sizeDropDown = By.xpath("");
    private final By quantity = By.xpath("");
    private final By addToCardButton = By.xpath("");
    private final By cartButton = By.xpath("");


    public TaskCPage openProductInfo() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(tShirtToAdd)).perform();
        driver.findElement(tShirtToAdd).click();
        return this;
    }

    public TaskCPage setProductColor(String color) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(addToCardButton)).perform();
        Select select = new Select(driver.findElement(colorDropDown));
//            List options = select.getAllSelectedOptions();
        select.selectByVisibleText(color);
        return this;
    }

    public TaskCPage setProductSize() {

        return this;
    }

    public TaskCPage setQuantity() {

        return this;
    }

    public TaskCPage addProductToCart() {

        return this;
    }

    public TaskCCartPage openTheCart() {

        return new TaskCCartPage(driver);
    }

}
//C) в задании использовать паттерн page object
//1. Open shop.demoqa.com
//2. Choose “PINK DROP SHOULDER OVERSIZED T SHIRT”
//3. Change Color to Pink
//4. Change size to 37
//5. Change quantity to 3
//6. Add to cart
//7. Navigate to cart and verify that product present in cart