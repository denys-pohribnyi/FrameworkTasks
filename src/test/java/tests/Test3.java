package tests;

import base.BaseTest;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoQACartPage;
import pages.DemoQAItemsListPage;
import pages.DemoQAPage;
import pages.WishListPage;

public class Test3 extends BaseTest {
    private DemoQAItemsListPage demoQAItemsListPage;
    private WishListPage wishListPage;

    @BeforeMethod
    public void setUp() {
        demoQAItemsListPage = new DemoQAItemsListPage(getDriver());
        wishListPage = new WishListPage(getDriver());
    }

    @Step("Step 1")
    @Description("Description")
    @Attachment(type = "Screenshot", value = "image/png")
    @Test
    public void addingToWishListTest() {
        openURL("https://shop.demoqa.com/");
        demoQAItemsListPage
                .addingPositionToWL()
                .openingWishList();
        wishListPage.checkingWishList("TEST TO FAIL");

    }


}
