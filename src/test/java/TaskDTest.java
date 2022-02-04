import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import taskD.TaskDPageFactory;

public class TaskDTest extends BaseTest {
    TaskDPageFactory taskDPageFactory;

    @BeforeMethod
    public void setUp() {
        taskDPageFactory = new TaskDPageFactory(getDriver());
    }

    @Test
    public void test() {
        openURL("http://shop.demoqa.com/author/lsharm/");
        taskDPageFactory
                .openingReadMore()
                .fillingFormName("Den")
                .fillingFormEmail("ahsgfhjas@gmail.com")
                .fillingFormWebsite("https://www.google.com")
                .fillingFormComment("Some comment")
                .formCheckbox()
                .postComment()
                .errorCheck("Error: You entered an incorrect CAPTCHA answer. Please go back and try again.");
    }
}
//D) в задании использовать паттерн page factory
//1. Open http://shop.demoqa.com/author/lsharm/
//2. Tap Read more
//3. Try to add comment without setting captcha
//4. Verify that you redirected to error page with “Error: You entered an incorrect CAPTCHA
//answer. Please go back and try again.” message