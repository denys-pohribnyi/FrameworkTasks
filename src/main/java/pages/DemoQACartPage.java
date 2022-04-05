package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQACartPage extends BasePage {
    private final WebDriver driver;

    public DemoQACartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By positionInTheList = By.xpath("//*[contains(text(),'pink drop shoulder oversized t shirt - Pink')]");

    public DemoQACartPage checkingProductInTheCart(String itemName) {
        moveToElement(positionInTheList);
        assertEq(positionInTheList, itemName);
        return this;
    }
}
