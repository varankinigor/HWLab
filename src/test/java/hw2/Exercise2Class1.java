package hw2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2Class1 extends TestBase {
    @Test(groups = "Smoke")
    public void test1() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[1]/li[1]")).isDisplayed());
    }
    @Test(groups = "Smoke")
    public void test2() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[1]/li[2]")).isDisplayed());
    }
    @Test(groups = "Smoke")
    public void test3() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[1]/li[3]")).isDisplayed());
    }
    @Test(groups = "Smoke")
    public void test4() {
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[1]/li[4]")).isDisplayed());
    }
}
