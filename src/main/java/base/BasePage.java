package base;

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

    public void moveToElement(WebElement element) {
        Actions action = new Actions(driver);     // or try getDriver();
        action.moveToElement(element).perform();
    }

    public void waitVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public void waitClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void select(WebElement element){
        Select select = new Select(element);
    }
}
//- base.BasePage где будут написаны и будут переиспользоваться методы для интеракции с
//элементами. В конструкторе есть driver - package page где будут page objects (все
//пейдж обжекты наследники base.BasePage)