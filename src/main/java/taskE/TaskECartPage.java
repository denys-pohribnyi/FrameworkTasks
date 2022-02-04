package taskE;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TaskECartPage extends BasePage {
    public TaskECartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[1]/td[2]")
    WebElement itemInTheList;

    public TaskECartPage checkingCart(String expectedItemName) {
        moveToElement(itemInTheList);
        String actualItemName = itemInTheList.getText();
        Assert.assertEquals(actualItemName, expectedItemName);
        return this;
    }


}
