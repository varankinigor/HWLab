package hw2;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Exercise2Class2 extends TestBase {
    @Test(groups = "Regression")
    public void test1() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[1]")).isDisplayed());
    }

    @Test(groups = "Regression")
    public void test2() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[2]")).isDisplayed());
    }

    @Test(groups = "Regression")
    public void test3() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[3]")).isDisplayed());
    }

    @Test(groups = "Regression")
    public void test4() {
        assertTrue(driver.findElement(By.xpath("//*[@id=\"mCSB_1_container\"]/ul/li[4]")).isDisplayed());
    }
}
