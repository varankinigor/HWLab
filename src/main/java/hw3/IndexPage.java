package hw3;

import enums.hw3.IndexPageTextsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class IndexPage {
    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private WebElement loginFormButton;

    @FindBy(css = "#Login")
    private WebElement loginTextBox;

    @FindBy(css = "#Password")
    private WebElement passwordTextDox;

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

    public void open(WebDriver driver, IndexPageTextsEnum url) {
        driver.navigate().to(url.text);
    }

    public void checkTitle(WebDriver driver, IndexPageTextsEnum title) {
        assertEquals(driver.getTitle(), title.text);
    }

    public void login(IndexPageTextsEnum login, IndexPageTextsEnum password) {
        loginFormButton.click();
        loginTextBox.sendKeys(login.text);
        passwordTextDox.sendKeys(password.text);
        loginButton.click();
    }

    public void checkName(IndexPageTextsEnum name) {
        assertEquals(loginName.getText(), name.text);
    }

    public void checkIsDisplayed4Images() {
        assertEquals(listImages.size(), 4);
        for (WebElement image : listImages) {
            assertTrue(image.isDisplayed());
        }
    }

    public void check4Texts(IndexPageTextsEnum text1, IndexPageTextsEnum text2, IndexPageTextsEnum text3, IndexPageTextsEnum text4) {
        assertEquals(listTexts.get(0).getText(), text1.text);
        assertEquals(listTexts.get(1).getText(), text2.text);
        assertEquals(listTexts.get(2).getText(), text3.text);
        assertEquals(listTexts.get(3).getText(), text4.text);
    }

    public void checkIsDisplayedMainHeader() {
        assertTrue(mainHeader.isDisplayed());
    }

    public void checkIsDisplayedMainText() {
        assertTrue(mainText.isDisplayed());
    }

    public void closeBrowser(WebDriver driver) {
        driver.close();
    }
}
