package base;

import data.TimeWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static base.BaseTest.getDriver;

public class BasePage {
    private WebDriver driver;

    public BasePage() {
        this.driver = getDriver();
    }


    public void click(By locator, TimeWait timeWait){
    WebDriverWait wait = new WebDriverWait(getDriver(),timeWait.getValue());
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    WebElement element = (WebElement) getDriver().findElement(locator);
    element.click();
    }

    public void moveToElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void waitVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public void waitClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void selectByText(WebElement element, String selectByText){
        Select select = new Select(element);
        select.selectByVisibleText(selectByText);
    }
}
//- base.BasePage где будут написаны и будут переиспользоваться методы для интеракции с
//элементами. В конструкторе есть driver - package page где будут page objects (все
//пейдж обжекты наследники base.BasePage)