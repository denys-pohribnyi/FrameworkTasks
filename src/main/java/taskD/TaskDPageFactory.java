package taskD;

import base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TaskDPageFactory extends BasePage {
    public TaskDPageFactory(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='The New Marc Jacobs Gotham Saddle Bag']")
    WebElement readMoreButton;
    @FindBy(xpath = "//input[@id='author']")
    WebElement nameField;
    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='url']")
    WebElement websiteField;
    @FindBy(xpath = "//textarea[@id='comment']")
    WebElement commentField;
    @FindBy(xpath = "//input[@id='wp-comment-cookies-consent']")
    WebElement checkBox;
    @FindBy(xpath = "//input[@id='submit']")
    WebElement postCommentButton;
    @FindBy(xpath = "//*[contains(text(),'Error: You entered an incorrect CAPTCHA answer. Please go back and try again.')]")
    WebElement errorMessage;

    public TaskDPageFactory openingReadMore() {
        moveToElement(readMoreButton);
        readMoreButton.click();
        return this;
    }

    public TaskDPageFactory fillingFormName(String name) {
        moveToElement(nameField);
        nameField.sendKeys(name);
        return this;
    }

    public TaskDPageFactory fillingFormEmail(String email) {
        moveToElement(emailField);
        emailField.sendKeys(email);
        return this;
    }

    public TaskDPageFactory fillingFormWebsite(String website) {
        moveToElement(websiteField);
        websiteField.sendKeys(website);
        return this;
    }

    public TaskDPageFactory fillingFormComment(String comment) {
        moveToElement(commentField);
        commentField.sendKeys(comment);
        return this;
    }

    public TaskDPageFactory formCheckbox() {
        moveToElement(checkBox);
        checkBox.click();
        return this;
    }

    public TaskDPageFactory postComment() {
        moveToElement(postCommentButton);
        postCommentButton.click();
        return this;
    }

    public TaskDPageFactory errorCheck(String errorExpected) {
        String errorActual = errorMessage.getText();
        Assert.assertEquals(errorActual, errorExpected);
        return this;
    }
}
//D) в задании использовать паттерн page factory
//1. Open http://shop.demoqa.com/author/lsharm/
//2. Tap Read more
//3. Try to add comment without setting captcha
//4. Verify that you redirected to error page with “Error: You entered an incorrect CAPTCHA
//answer. Please go back and try again.” message