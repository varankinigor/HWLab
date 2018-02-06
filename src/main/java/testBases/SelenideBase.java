package testBases;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class SelenideBase {
    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
    }
}
