package hw3;

import enums.IndexPageEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static enums.IndexPageBenefitsEnum.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {

    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormDropdown;

    @FindBy(css = "#Login")
    private WebElement loginTextBox;

    @FindBy(css = "#Password")
    private WebElement passwordTextBox;

    @FindBy(css = ".form-horizontal [type='submit']")
    private WebElement loginButton;

    @FindBy(css = ".profile-photo span")
    private WebElement loginName;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> listImages;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> listTexts;

    @FindBy(css = ".main-title")
    private WebElement mainHeader;

    @FindBy(css = ".main-txt")
    private WebElement mainText;

    public void open(IndexPageEnum url) {
        driver.navigate().to(url.text);
    }

    public void checkTitle(IndexPageEnum title) {
        assertEquals(driver.getTitle(), title.text);
    }

    public void login(IndexPageEnum login, IndexPageEnum password) {
        if (!loginName.isDisplayed()) {
            loginFormDropdown.click();
            loginTextBox.sendKeys(login.text);
            passwordTextBox.sendKeys(password.text);
            loginButton.click();
        }
    }

    public void checkLoginName(IndexPageEnum name) {
        assertEquals(loginName.getText(), name.text);
    }

    public void checkIsDisplayed4Images() {
        assertEquals(listImages.size(), 4);
        for (WebElement image : listImages) {
            assertTrue(image.isDisplayed());
        }
    }

//В последнем ассерте использовал реплейс троеточия, так как почему то в jenkins тест крашится, видя вместо троеточия абракадабру
    public void check4Texts() {
        assertEquals(listTexts.get(PRACTICE.ordinal()).getText(), PRACTICE.text);
        assertEquals(listTexts.get(CUSTOM.ordinal()).getText(), CUSTOM.text);
        assertEquals(listTexts.get(MULTI.ordinal()).getText(), MULTI.text);
        assertEquals(listTexts.get(BASE.ordinal()).getText().replace("…", ""), BASE.text);
    }

    public void checkIsDisplayedMainHeader() {
        assertTrue(mainHeader.isDisplayed());
    }

    public void checkIsDisplayedMainText() {
        assertTrue(mainText.isDisplayed());
    }
}