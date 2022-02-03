import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskCTest extends BaseTest{
    private TaskCPage taskCPage;
    private TaskCCartPage taskCCartPage;

    @BeforeMethod
    public void setUp() {
        taskCPage = new TaskCPage(getDriver());
        taskCCartPage = new TaskCCartPage(getDriver());
    }

    @Test
    public void addingTShirtToCardTest(){
        openURL("https://shop.demoqa.com/");
        taskCPage
                .openProductInfo()
                .setProductColor("Pink")
                .setProductSize()
                .setQuantity()
                .addProductToCart()
                .openTheCart();
        taskCCartPage.checkingProductInTheCart();
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