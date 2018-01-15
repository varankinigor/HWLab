package hw2;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise2Class2 extends TestBase {
    @Test(groups = "Regression")
    public void test1() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[1]")).isDisplayed());
    }

    @Test(groups = "Regression")
    public void test2() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[2]")).isDisplayed());
    }

    @Test(groups = "Regression")
    public void test3() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[3]")).isDisplayed());
    }

    @Test(groups = "Regression")
    public void test4() {
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[4]")).isDisplayed());
    }
}
