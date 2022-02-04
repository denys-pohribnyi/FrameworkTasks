package taskC;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TaskCCartPage extends BasePage {
    private final WebDriver driver;

    public TaskCCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By positionInTheList = By.xpath("//*[contains(text(),'pink drop shoulder oversized t shirt - Pink')]");

    public TaskCCartPage checkingProductInTheCart(String itemName) {
        moveToElement(driver.findElement(positionInTheList));
        String positionName = driver.findElement(positionInTheList).getText();
        Assert.assertEquals(positionName, itemName);
        return this;
    }
}
