package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.List;

import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Exercise3 {
    private WebDriver driver;

    @BeforeSuite
    public void beforeSuitMethod() {
        setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @BeforeTest
    public void beforeTestMethod() {
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void beforeClassMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void afterTestMethod() {
        driver.close();
    }

    @AfterSuite
    public void afterSuiteMethod() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @Test
    public void testEpamWebPage() {
        driver.manage().window().maximize();

        //2 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //3 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //4 Perform login
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button")).click();

        //5 Assert User name in the left(right!)-top side of screen that user is loggined
        String name = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/span")).getText();
        assertEquals(name, "PITER CHAILOVSKII");

        //6 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> listImages = driver.findElements(By.className("benefit-icon"));
        assertEquals(listImages.size(), 4);
        for (WebElement image : listImages) {
            assertTrue(image.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> listTexts = driver.findElements(By.className("benefit-txt"));
        assertEquals(listTexts.size(), 4);
        assertEquals(listTexts.get(0).getText(), "To include good practices\nand ideas from successful\nEPAM projec");
        assertEquals(listTexts.get(1).getText(), "To be flexible and\ncustomizable");
        assertEquals(listTexts.get(2).getText(), "To be multiplatform");
        assertEquals(listTexts.get(3).getText(), "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert that there are the main header and the text below it on the Home Page
        WebElement elementMainTitle = driver.findElement(By.className("main-title"));
        assertTrue(elementMainTitle.isDisplayed());
        WebElement elementMainText = driver.findElement(By.className(("main-txt")));
        assertTrue(elementMainText.isDisplayed());
    }
}
