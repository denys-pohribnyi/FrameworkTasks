package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQAPage extends BasePage {
    private final WebDriver driver;

    public DemoQAPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By tShirtToAdd = By.xpath("//*[contains(text(),'pink drop shoulder oversized t shirt')]");
    private final By colorDropDown = By.xpath("//*[@id=\"pa_color\"]");
    private final By sizeDropDown = By.xpath("//*[@id=\"pa_size\"]");
    private final By quantity = By.xpath("//*[@class='input-text qty text']");
    private final By addToCardButton = By.xpath("//*[@id=\"product-1497\"]/div[1]/div[2]/form/div/div[2]/button");
    private final By cartButton = By.xpath("//*[@id=\"noo-site\"]/div[2]/div/div/div[1]/div/a");

    public DemoQAPage openProductInfo() {
        moveToElement(driver.findElement(tShirtToAdd));
        driver.findElement(tShirtToAdd).click();
        return this;
    }

    public DemoQAPage setProductColor(String color) {
        moveToElement(driver.findElement(addToCardButton));
        selectByText(driver.findElement(colorDropDown),color);
        return this;
    }

    public DemoQAPage setProductSize(String size) {
        moveToElement(driver.findElement(sizeDropDown));
        selectByText(driver.findElement(sizeDropDown),size);
        return this;
    }

    public DemoQAPage setQuantity(String setQuantity) {
        moveToElement(driver.findElement(quantity));
        driver.findElement(quantity).clear();
        driver.findElement(quantity).sendKeys(setQuantity);
        return this;
    }

    public DemoQAPage addProductToCart() {
        moveToElement(driver.findElement(addToCardButton));
        driver.findElement(addToCardButton).click();
        return this;
    }

    public DemoQACartPage openTheCart() {
        moveToElement(driver.findElement(cartButton));
        waitClickable(driver.findElement(cartButton));
        return new DemoQACartPage(driver);
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