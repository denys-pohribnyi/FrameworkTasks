package tests;

import base.BaseTest;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoQAItemsListPage;
import pages.WishListPage;

public class Test3 extends BaseTest {
    private DemoQAItemsListPage demoQAItemsListPage;
    private WishListPage wishListPage;

    @BeforeMethod
    public void setUp() {
        demoQAItemsListPage = new DemoQAItemsListPage(getDriver());
        wishListPage = new WishListPage(getDriver());
    }


    @Description("Adding item to wish list")
    @Test
    public void addingToWishListTest() {
        openURL("https://shop.demoqa.com/");
        demoQAItemsListPage
                .addingPositionToWL()
                .openingWishList();
        wishListPage.checkingWishList("TEST TO FAIL");

    }


}
