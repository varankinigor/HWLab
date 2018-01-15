package hw2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2Class3 extends TestBase {
    @Test(groups = "Smoke")
    public void test1() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div/div[1]/div/span")).isDisplayed());
    }

    @Test(groups = "Regression")
    public void test2() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div/div[2]/div/span")).isDisplayed());
    }

    @Test(groups = {"Smoke", "Regression"})
    public void test3() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div/div[3]/div/span")).isDisplayed());
    }

    @Test(groups = {"Smoke", "Regression"})
    public void test4() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div/main/div[2]/div/div[4]/div/span")).isDisplayed());
    }

}
