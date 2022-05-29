package tests;

import base.BasePage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test5 extends BasePage {
    @Step("Test 5")
    @Test
    public void test5(){
        System.out.println("Test 5");
    }

    @Step("Checking screenshot is taking")
    @Description("Verify that failed test case takes a screenshot")
    @Test
    @Attachment(type = "Screenshot", value = "image/png")
    public void test6(){
        int x = 1;
        Assert.assertEquals(x,0);
    }
}
