package hw4.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import edu.emory.mathcs.backport.java.util.Collections;
import enums.DifElemEnum;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Condition.*;

public class DifElemPage {
    @FindBy(css = ".label-checkbox")
    private ElementsCollection chexboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".colors .uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".main-content .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "[id='mCSB_1_container']")
    private SelenideElement leftSection;

    @FindBy(css = ".right-fix-panel")
    private SelenideElement rightSection;

    @FindBy(css = "ul.panel-body-list.logs li")
    private ElementsCollection actualLog;

    private List<String> expectedLog = new ArrayList<>();

    @Step
    public void checkDifElemPageInterfaceElements() {
        chexboxes.shouldHaveSize(4);
        radios.shouldHaveSize(4);
        buttons.shouldHaveSize(2);
        dropdown.should(visible);
        for (SelenideElement button : buttons) {
            button.should(visible);
        }
        leftSection.should(visible);
        rightSection.should(visible);
    }

    @Step
    public void selectCheckbox(DifElemEnum elem) {
        chexboxes.find(text(elem.text)).click();
        chexboxes.find(text(elem.text)).$("input").should(checked);
        expectedLog.add(elem.text + ": condition changed to true");
    }

    @Step
    //селен не металл :(
    public void selectRadio(DifElemEnum metal) {
        radios.find(text(metal.text)).click();
        radios.find(text(metal.text)).$("input").should(checked);
        expectedLog.add("metal: value changed to " + metal.text);
    }

    @Step
    public void selectDropdown(DifElemEnum color) {
        dropdown.selectOption(color.text);
        dropdown.shouldBe(text(color.text));
        expectedLog.add("Colors: value changed to " + color.text);
    }

    @Step
    public void checkLog() {
        actualLog.shouldHaveSize(expectedLog.size());
        Collections.reverse(expectedLog);
        for (int i = 0; i < expectedLog.size(); i++) {
            Assert.assertTrue(actualLog.get(i).getText().endsWith(expectedLog.get(i)));
        }
        Collections.reverse(expectedLog);
    }

    @Step
    public void unselectCheckbox(DifElemEnum elem) {
        chexboxes.find(text(elem.text)).click();
        chexboxes.find(text(elem.text)).$("input").shouldNot(checked);
        expectedLog.add(elem.text + ": condition changed to false");
    }
}
