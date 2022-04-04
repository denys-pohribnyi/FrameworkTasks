package pages;

import base.BasePage;
import data.TimeWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQAItemsListPage extends BasePage {
    private final WebDriver driver;

    public DemoQAItemsListPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By positionToAdd = By.xpath("//*[contains(text(),'Tokyo Talkies')]");
    private final By wishListButton = By.cssSelector(".add_to_wishlist.single_add_to_wishlist[href='?add_to_wishlist=704&_wpnonce=da759fc31d']");
    private final By wishListPage = By.xpath("//*[contains(text(),'My Wishlist')]");
    private final By messageItemIsAdded = By.xpath("//div[@id='yith-wcwl-message']");


    public DemoQAItemsListPage addingPositionToWL() {
        moveToElement(driver.findElement(positionToAdd));
        click(wishListButton, TimeWait.TIME_WAIT_5);
        waitVisibility(driver.findElement(messageItemIsAdded));
        return this;
    }

    public WishListPage openingWishList() {
        click(wishListPage,TimeWait.TIME_WAIT_10);
        return new WishListPage(driver);
    }

}
//B) в задании использовать паттерн page object
//1. Open shop.demoqa.com
//2. Favorite Tokyo-Talkies (Add to Wishlist)
//3. Open wishlist
//4. Verify that Tokyo-Talkies is present in wishlist