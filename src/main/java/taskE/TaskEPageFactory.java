package taskE;

import base.BasePage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TaskEPageFactory extends BasePage {
    public TaskEPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;
    @FindBy(xpath = "//a[@class='noo-search']")
    WebElement searchButton;

    @FindBy(xpath = "//input[@name='s']")
    WebElement searchField;

    @FindBy(xpath = "//select[@name='filter_size']")
    WebElement filterSize;

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[1]")  //[1] is the first product
    WebElement firstProduct;

    @FindBy(xpath = "//select[@id='pa_color']")
    WebElement chooseColor;

    @FindBy(xpath = "//select[@id='pa_size']")
    WebElement chooseSize;

    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='button wc-forward']")
    WebElement linkToCartPage;

    public TaskEPageFactory searchItem(String search) {
        searchButton.click();
        searchField.sendKeys(search);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }

    public TaskEPageFactory filterSize(String size) {
        Select select = new Select(filterSize);
        select.selectByVisibleText(size);
        return this;
    }

    public TaskEPageFactory chooseFirstProduct() {
        moveToElement(firstProduct);
        firstProduct.click();
        return this;
    }

    public TaskEPageFactory selectColor(String color) {
        moveToElement(chooseColor);
        Select select = new Select(chooseColor);
        select.selectByVisibleText(color);
        return this;
    }

    public TaskEPageFactory selectSize(String size) {
        moveToElement(chooseSize);
        Select select = new Select(chooseSize);
        select.selectByVisibleText(size);
        return this;
    }

    public TaskEPageFactory addToCart() {
        moveToElement(addToCartButton);
        addToCartButton.click();
        return this;
    }

    public TaskECartPage openingCartPage() {
        moveToElement(linkToCartPage);
        linkToCartPage.click();
        return new TaskECartPage(driver);
    }

}
//E) в задании использовать паттерн page factory
//1. Open http://shop.demoqa.com/
//2. Search “Blue” query
//3. Select 37 size
//4. Choose first one product
//5. Choose color
//6. Choose size
//7. Add to cart
//8. Navigate to cart and verify that product present in cart