package taskAB;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListAddingPosition extends BasePage {
    private final WebDriver driver;

    public WishListAddingPosition(WebDriver driver) {
        this.driver = driver;
    }

    private final By positionToAdd = By.xpath("//*[contains(text(),'Tokyo Talkies')]");
    private final By wishListButton = By.xpath("/html[1]/body[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]");
    private final By wishListPage = By.xpath("//*[contains(text(),'My Wishlist')]");
    private final By messageItemIsAdded = By.xpath("//div[@id='yith-wcwl-message']");


    public WishListAddingPosition addingPositionToWL() {
        moveToElement(driver.findElement(positionToAdd));
        driver.findElement(wishListButton).click();
        driver.findElement(positionToAdd).isDisplayed();
        waitVisibility(driver.findElement(messageItemIsAdded));
        return this;
    }

    public WishListPage openingWL() {
        driver.findElement(wishListPage).click();
        return new WishListPage(driver);
    }

}
//B) в задании использовать паттерн page object
//1. Open shop.demoqa.com
//2. Favorite Tokyo-Talkies (Add to Wishlist)
//3. Open wishlist
//4. Verify that Tokyo-Talkies is present in wishlist