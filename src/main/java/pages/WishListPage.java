package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class WishListPage {
    private final WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By itemInWishList = By.xpath("//*[contains(text(),'Tokyo Talkies')]");

    public WishListPage checkingWishList(String expectedItem) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(itemInWishList)).perform();
        Assert.assertEquals(driver.findElement(itemInWishList).getText(), expectedItem);
        return this;
    }

}
