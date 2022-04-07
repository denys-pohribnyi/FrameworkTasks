package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoQACartPage;
import pages.DemoQAPage;

public class TaskCTest extends BaseTest {
    private DemoQAPage demoQAPage;
    private DemoQACartPage demoQACartPage;

    @BeforeMethod
    public void setUp() {
        demoQAPage = new DemoQAPage(getDriver());
        demoQACartPage = new DemoQACartPage(getDriver());
    }

    @Test
    public void addingTShirtToCardTest() {
        openURL("https://shop.demoqa.com/");
        demoQAPage
                .openProductInfo()
                .setProductColor("Pink")
                .setProductSize("37")
                .setQuantity("3")
                .addProductToCart()
                .openTheCart();
        demoQACartPage.checkingProductInTheCart("PINK DROP SHOULDER OVERSIZED T SHIRT - PINK")
                .checkTextIsAbsent("some text");
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