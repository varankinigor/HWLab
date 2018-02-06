package hw4.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.IndexPageEnum;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static enums.ServiceDropdownEnum.TEXT_1;
import static enums.ServiceDropdownEnum.values;

public class IndexPage {

    @FindBy(css = ".uui-profile-menu .dropdown-toggle")
    private SelenideElement loginFormDropdown;

    @FindBy(css = "#Login")
    private SelenideElement loginTextBox;

    @FindBy(css = "#Password")
    private SelenideElement passwordTextBox;

    @FindBy(css = ".form-horizontal [type='submit']")
    private SelenideElement loginButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement loginName;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection collectionImages;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection collectionTexts;

    @FindBy(css = ".main-title")
    private SelenideElement mainHeader;

    @FindBy(css = ".main-txt")
    private SelenideElement mainText;

    @FindBy(css = ".dropdown a")
    private SelenideElement headerServiceDropdown;

    @FindBy(css = ".dropdown li")
    private ElementsCollection headerServiceDropdownMenu;

    @FindBy(css = ".sub-menu a")
    private SelenideElement leftServiceSidebar;

    @FindBy(css = ".sub li")
    private ElementsCollection leftServiceSidebarMenu;

    @FindBy(css = "a[href='different-elements.html']")
    private SelenideElement headerServiceDifferenElementsLink;

    @FindBy(css = "a[href='dates.html']")
    private SelenideElement headerServiceDatesLink;

    @Step
    public void openIndexPage() {
        open(IndexPageEnum.URL.text);
    }

    @Step
    public void login(IndexPageEnum login, IndexPageEnum password) {
        if (!loginName.isDisplayed()) {
            loginFormDropdown.click();
            loginTextBox.sendKeys(login.text);
            passwordTextBox.sendKeys(password.text);
            loginButton.click();
        }
    }

    @Step
    public void checkLoginName(IndexPageEnum name) {
        loginName.should(text(name.text));
    }

    @Step
    public void checkIndexPageInterfaceElements() {
        collectionImages.shouldHaveSize(4);
        collectionTexts.shouldHaveSize(4);
        mainHeader.should(Condition.visible);
        mainText.should(Condition.visible);
    }

    @Step
    public void checkHeaderServiceSubcategory() {
        headerServiceDropdown.click();
        headerServiceDropdownMenu.shouldHaveSize(values().length);
        for (enums.ServiceDropdownEnum s : values()) {
            headerServiceDropdownMenu.get(TEXT_1.ordinal()).should(text(TEXT_1.text));
        }
    }

    @Step
    public void checkLeftServiceSubcategory() {
        leftServiceSidebar.click();
        leftServiceSidebarMenu.shouldHaveSize(values().length);
        for (enums.ServiceDropdownEnum s : values()) {
            leftServiceSidebarMenu.get(TEXT_1.ordinal()).should(text(TEXT_1.text));
        }
    }

    @Step
    public void openHeaderServiceDifferentElementsPage() {
        headerServiceDropdown.click();
        headerServiceDifferenElementsLink.click();
    }

    @Step
    public void openHeaderServiceDatesPage() {
        headerServiceDropdown.click();
        headerServiceDatesLink.click();
    }
}
