package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    private static final ThreadLocal<WebDriver> WEBDRIVER_CONTAINER = new ThreadLocal<WebDriver>();

    public void openURL(String url) {
        driver.get(url);
    }

    @BeforeClass
    public static void setupClass() {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WEBDRIVER_CONTAINER.set(driver);
    }

    public static WebDriver getDriver() {
        return WEBDRIVER_CONTAINER.get();
    }

    @AfterClass
    public void quit() {

        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            WEBDRIVER_CONTAINER.remove();
        }
    }
}
//1. В проекте где написаны пейдж обжекты создать 2 сьюта. Один который запускает
//все тесты из пэкеджа второй с набором классов. (Т к некоторые создавали разные
//проекты, то эти 2 сьюта могут содержать одни и те же тесты)
//2. Добавить в pom файл maven-surefire-plugin c suiteXmlFiles для того чтобы была
//возможность запускать сьюты из командной строки
//3. Установить аллюр на машину, проверить с помощью allure --version
//4. Добавить allure testng dependency в проект
//5. Добавить логи на действия
//6. Запустить сьют по maven команде
//В домашку приложить скрин allure report’a