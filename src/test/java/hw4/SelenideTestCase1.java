package hw4;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import enums.DifElemEnum;
import hw4.page_objects.DifElemPage;
import hw4.page_objects.IndexPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.page;
import static enums.IndexPageEnum.*;

@Listeners(listeners.AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Selenide Test Case 1"})
public class SelenideTestCase1 {
    private IndexPage indexPage;
    private DifElemPage difElemPage;

    @BeforeSuite(alwaysRun = true)
    public void setUpSuite() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        indexPage = page(IndexPage.class);
        difElemPage = page(DifElemPage.class);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }

    @Test
    public void indexAndServicePagesTest() {
        //1 Open test site by URL
        indexPage.openIndexPage(URL);
        //2 Perform login
        indexPage.login(LOGIN, PASSWORD);
        //3 Assert User name in the left(right!!!)-top side of screen that user is loggined
        indexPage.checkLoginName(NAME);
        //4 Check interface on Home page, it contains all needed elements.
        indexPage.checkIndexPageInterfaceElements();
        //5 Click on "Service" subcategory in the header and check that drop down contains options
        indexPage.checkHeaderServiceSubcategory();
        //6 Click on Service subcategory in the left section and check that drop down contains options
        indexPage.checkLeftServiceSubcategory();
        //7 Open through the header menu Service -> Different Elements Page
        indexPage.openHeaderServiceDifferentElementsPage();

        //8 Check interface on Service page, it contains all needed elements.
        difElemPage.checkDifElemPageInterfaceElements();
        //9 Select and assert checkboxes
        difElemPage.selectCheckbox(DifElemEnum.WATER);
        difElemPage.selectCheckbox(DifElemEnum.WIND);
        //10 Select radio
        difElemPage.selectRadio(DifElemEnum.SELEN);
        //11 Select in dropdown
        difElemPage.selectDropdown(DifElemEnum.YELLOW);
        //12 Check in logs section selected values and status (true|false)
        difElemPage.checkLog();
        //13 Unselect and assert checkboxes
        difElemPage.unselectCheckbox(DifElemEnum.WATER);
        difElemPage.unselectCheckbox(DifElemEnum.WIND);
        //14 Check in logs section unselected values and status (true|false)
        difElemPage.checkLog();
    }
}
