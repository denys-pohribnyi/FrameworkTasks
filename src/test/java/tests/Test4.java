package tests;

import base.BaseTest;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoQAItemsListPage;
import pages.WishListPage;

public class Test4 extends BaseTest {
    private DemoQAItemsListPage demoQAItemsListPage;
    private WishListPage wishListPage;

    @BeforeMethod
    public void setUp() {
        demoQAItemsListPage = new DemoQAItemsListPage(getDriver());
        wishListPage = new WishListPage(getDriver());
    }

    @Step("Adding to WishList 3rd time")
    @Test
    public void addingToWishListTest() {
        openURL("https://shop.demoqa.com/");
        demoQAItemsListPage
                .addingPositionToWL()
                .openingWishList();
        wishListPage.checkingWishList("TOKYO TALKIES");

    }
}
