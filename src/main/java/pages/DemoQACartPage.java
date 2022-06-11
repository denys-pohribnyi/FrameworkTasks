package pages;

import base.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoQACartPage extends BasePage {
    private final WebDriver driver;

    public DemoQACartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By positionInTheList = By.xpath("//*[contains(text(),'pink drop shoulder oversized t shirt - Pink')]");
    private final By elementWithoutText = By.xpath("//*[@id=\"post-6\"]/div/div/form/table/tbody/tr[1]/td[4]/div/div/button[1]");

    @Step("Check product in the cart")
    public DemoQACartPage checkingProductInTheCart(String itemName) {
        moveToElement(positionInTheList);
        assertTextPresenceOrAbsence(positionInTheList, itemName, true);
        System.out.println("done");
        return this;
    }

    @Step("Check that text is absent")
    public DemoQACartPage checkTextIsAbsent(String itemName) {
        moveToElement(elementWithoutText);
        assertTextPresenceOrAbsence(elementWithoutText, itemName, false);
        return this;
    }
}
