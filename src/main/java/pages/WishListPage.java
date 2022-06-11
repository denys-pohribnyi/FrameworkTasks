package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends BasePage {
    private final WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By itemInWishList = By.xpath("//*[contains(text(),'Tokyo Talkies')]");

    @Step("Check wish list")
    public WishListPage checkingWishList(String expectedItem) {
        moveToElement(itemInWishList);
        assertTextPresenceOrAbsence(itemInWishList, expectedItem, true);
        return this;
    }

}
