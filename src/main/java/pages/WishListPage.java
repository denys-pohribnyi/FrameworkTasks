package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class WishListPage extends BasePage {
    private final WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By itemInWishList = By.xpath("//*[contains(text(),'Tokyo Talkies')]");

    public WishListPage checkingWishList(String expectedItem) {
        moveToElement(driver.findElement(itemInWishList));
        Assert.assertEquals(driver.findElement(itemInWishList).getText(), expectedItem);
        return this;
    }

}
