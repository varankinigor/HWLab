package hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class TestBase {
    static WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }
}
