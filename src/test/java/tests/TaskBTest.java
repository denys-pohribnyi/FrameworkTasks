package tests;

import base.BaseTest;
import io.qameta.allure.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DemoQAItemsListPage;
import pages.WishListPage;

public class TaskBTest extends BaseTest {
    private DemoQAItemsListPage demoQAItemsListPage;
    private WishListPage wishListPage;

    @BeforeMethod
    public void setUp() {
        demoQAItemsListPage = new DemoQAItemsListPage(getDriver());
        wishListPage = new WishListPage(getDriver());
    }

    @Description("Adding item to WishList")
    @Test
    public void addingToWishListTest() {
        openURL("https://shop.demoqa.com/");
        demoQAItemsListPage
                .addingPositionToWL()
                .openingWishList();
        wishListPage.checkingWishList("TOKYO TALKIES");

    }
}
//A) Сделать (или апдейтнуть текущий) новый проект:
//- Должен быть base.BaseTest для сетапа драйверов
//- base.BasePage где будут написаны и будут переиспользоваться методы для интеракции с
//элементами. В конструкторе есть driver - package page где будут page objects (все
//пейдж обжекты наследники base.BasePage)
//B) в задании использовать паттерн page object
//1. Open shop.demoqa.com
//2. Favorite Tokyo-Talkies (Add to Wishlist)
//3. Open wishlist
//4. Verify that Tokyo-Talkies is present in wishlist
//C) в задании использовать паттерн page object
//1. Open shop.demoqa.com
//2. Choose “PINK DROP SHOULDER OVERSIZED T SHIRT”
//3. Change Color to Pink
//4. Change size to 37
//5. Change quantity to 3
//6. Add to cart
//7. Navigate to cart and verify that product present in cart
//D) в задании использовать паттерн page factory
//1. Open http://shop.demoqa.com/author/lsharm/
//2. Tap Read more
//3. Try to add comment without setting captcha
//4. Verify that you redirected to error page with “Error: You entered an incorrect CAPTCHA
//answer. Please go back and try again.” message
//E) в задании использовать паттерн page factory
//1. Open http://shop.demoqa.com/
//2. Search “Blue” query
//3. Select 37 size
//4. Choose first one product
//5. Choose color
//6. Choose size
//7. Add to cart
//8. Navigate to cart and verify that product present in cart