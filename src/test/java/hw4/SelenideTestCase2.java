package hw4;

import hw4.page_objects.DatesPage;
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
@Stories({"Selenide Test Case 2"})
public class SelenideTestCase2 extends SelenideBase {
    private IndexPage indexPage;
    private DatesPage datesPage;

    @BeforeClass(alwaysRun = true)
    public void setUp() {
        indexPage = page(IndexPage.class);
        datesPage = page(DatesPage.class);
    }

    @Test
    public void indexAndDatesPagesTest() {
        //1 Open test site by URL
        indexPage.openIndexPage();

        //2 Perform login
        indexPage.login(LOGIN, PASSWORD);

        //3 Assert User name in the left-top side of screen that user is loggined
        indexPage.checkLoginName(NAME);

        //4 Open Service -> Dates
        indexPage.openHeaderServiceDatesPage();

        //5 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most rigth position
        datesPage.setAndCheckSliders(0, 100);

        //6 Using drag-and-drop set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.setAndCheckSliders(0, 0);

        //7 Using drag-and-drop set Range sliders. left sliders - the most rigth position, right slider - the most rigth position.
        datesPage.setAndCheckSliders(100, 100);

        //8 Using drag-and-drop set Range sliders.
        datesPage.setAndCheckSliders(30, 70);
    }
}
