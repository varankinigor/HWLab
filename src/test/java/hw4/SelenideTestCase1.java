package hw4;

import enums.DifElemEnum;
import hw4.page_objects.DifElemPage;
import hw4.page_objects.IndexPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import testBases.SelenideBase;

import static com.codeborne.selenide.Selenide.page;
import static enums.IndexPageEnum.*;

@Listeners(listeners.AllureAttachmentListener.class)
@Features({"Selenide Test Suite"})
@Stories({"Selenide Test Case 1"})
public class SelenideTestCase1 extends SelenideBase {
    private IndexPage indexPage;
    private DifElemPage difElemPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        indexPage = page(IndexPage.class);
        difElemPage = page(DifElemPage.class);
    }

    @Test
    public void indexAndServicePagesTest() {
        //1 Open test site by URL
        indexPage.openIndexPage();

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
        difElemPage.checkLog(DifElemEnum.WATER);
        difElemPage.checkLog(DifElemEnum.WIND);
        difElemPage.checkLog(DifElemEnum.SELEN);
        difElemPage.checkLog(DifElemEnum.YELLOW);

        //13 Unselect and assert checkboxes
        difElemPage.unselectCheckbox(DifElemEnum.WATER);
        difElemPage.unselectCheckbox(DifElemEnum.WIND);

        //14 Check in logs section unselected values and status (true|false)
        difElemPage.checkLog(DifElemEnum.WATER);
        difElemPage.checkLog(DifElemEnum.WIND);
    }
}
