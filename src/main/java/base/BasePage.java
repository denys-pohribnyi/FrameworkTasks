package base;

import data.TimeWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static base.BaseTest.getDriver;

public class BasePage {
    private WebDriver driver;

    public BasePage() {
        this.driver = getDriver();
    }


    public void click(By locator, TimeWait timeWait) {
        WebDriverWait wait = new WebDriverWait(getDriver(), timeWait.getValue());
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).click();
    }

    public void moveToElement(By element) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(element)).perform();
    }

    public void waitVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator))).isDisplayed();
    }

    public void selectByText(By locator, String selectByText) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(selectByText);
    }

    public void assertEq(By locator, String itemName) {
        Assert.assertEquals(driver.findElement(locator).getText(), itemName);
    }

    public void clearField(By locator) {
        driver.findElement(locator).clear();
    }

    public void sendKeys(By locator, String keysToSend) {
        driver.findElement(locator).sendKeys(keysToSend);
    }

}
//- base.BasePage где будут написаны и будут переиспользоваться методы для интеракции с
//элементами. В конструкторе есть driver - package page где будут page objects (все
//пейдж обжекты наследники base.BasePage)