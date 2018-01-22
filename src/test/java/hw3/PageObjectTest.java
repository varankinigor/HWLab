package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static enums.hw3.IndexPageTextsEnum.*;

public class PageObjectTest {
    private WebDriver driver;
    private IndexPage indexPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        indexPage = PageFactory.initElements(driver, IndexPage.class);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        //10 Close Browser
        indexPage.closeBrowser(driver);
    }

    @Test
    public void SimpleTest() {
        //2 Open test site by URL
        indexPage.open(driver, URL.text);
        //3 Assert Browser title
        indexPage.checkTitle(driver, TITLE.text);
        //4 Perform login
        indexPage.login(LOGIN.text, PASSWORD.text);
        //5 Assert User name in the left(right!)-top side of screen that user is loggined
        indexPage.checkName(NAME.text);
        //6 Assert Browser title
        indexPage.checkTitle(driver, TITLE.text);
        //7 Assert that there are 4 images on the Home Page and they are displayed
        indexPage.checkIsDisplayed4Images();
        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        indexPage.check4Texts(TEXT_1.text, TEXT_2.text, TEXT_3.text, TEXT_4.text);
        //9 Assert that there are the main header and the text below it on the Home Page
        indexPage.checkIsDisplayedMainHeader();
        indexPage.checkIsDisplayedMainText();
    }
}
