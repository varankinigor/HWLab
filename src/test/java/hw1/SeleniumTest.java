package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

//1 Create a new test in a new Java class, specify test name in accordance with checking functionality
public class SeleniumTest {
    @Test
    public void testEpamWebPage() {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests");

        //3 Assert Browser title
        Assert.assertEquals(driver.getTitle(),"Index Page");

        //4 Perform login
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li")).click();
        driver.findElement(By.id("Login")).sendKeys("epam");
        driver.findElement(By.id("Password")).sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button")).click();

        //5 Assert User name in the left(right!)-top side of screen that user is loggined
        String name = driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/a/div/span")).getText();
        Assert.assertEquals(name, "PITER CHAILOVSKII");

        //6 Assert Browser title
        Assert.assertEquals(driver.getTitle(),"Index Page");

        //7 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> listImages = driver.findElements(By.className("benefit-icon"));
        Assert.assertEquals(listImages.size(), 4);
        for (WebElement image: listImages) {
            Assert.assertTrue(image.isDisplayed());
        }

        //8 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> listTexts = driver.findElements(By.className("benefit-txt"));
        Assert.assertEquals(listTexts.size(), 4);
        Assert.assertEquals(listTexts.get(0).getText(),
                "To include good practices\nand ideas from successful\nEPAM projec");
        Assert.assertEquals(listTexts.get(1).getText(),
                "To be flexible and\ncustomizable");
        Assert.assertEquals(listTexts.get(2).getText(),
                "To be multiplatform");
        Assert.assertEquals(listTexts.get(3).getText(),
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

        //9 Assert that there are the main header and the text below it on the Home Page
        WebElement elementMainTitle = driver.findElement(By.className("main-title"));
        Assert.assertTrue(elementMainTitle.isDisplayed());
        WebElement elementMainText = driver.findElement(By.className(("main-txt")));
        Assert.assertTrue(elementMainText.isDisplayed());

        //10 Close Browser
        driver.close();
    }

}