package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Exercise1 extends TestBase {

    @DataProvider(parallel = true)
    public Object[][] dp() {
        return new Object[][] {
                {"To include good practices\nand ideas from successful\nEPAM projec"},
                {"To be flexible and\ncustomizable"},
                {"To be multiplatform"},
                {"Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }
    @Test(dataProvider = "dp")
    public void dpTest(String expectedText) {
        List<WebElement> listTexts = driver.findElements(By.className("benefit-txt"));
        boolean isFound = false;
        for (WebElement elementText : listTexts) {
            if (elementText.getText().equals(expectedText)) {
                isFound = true;
                break;
            }
        }
        Assert.assertTrue(isFound);
    }
}
