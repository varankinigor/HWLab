package hw4.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DifElemEnum;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static utils.LogWork.prepareLog;

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
    private List<SelenideElement> actualLogList;

    private Map<String, String> expectedLogMap = new HashMap<>();

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
        expectedLogMap.put(elem.text, "true");
    }

    @Step
    public void selectRadio(DifElemEnum metal) {
        radios.find(text(metal.text)).click();
        radios.find(text(metal.text)).$("input").should(checked);
        expectedLogMap.put("metal", metal.text);
    }

    @Step
    public void selectDropdown(DifElemEnum color) {
        dropdown.selectOption(color.text);
        dropdown.shouldBe(text(color.text));
        expectedLogMap.put("Colors", color.text);
    }

    @Step
    public void checkLog(DifElemEnum... keyArr) {
        Map<String, String> actualLogMap = prepareLog(actualLogList);
        Assert.assertEquals(actualLogMap.size(), expectedLogMap.size());
        for(DifElemEnum key : keyArr) {
            Assert.assertEquals(actualLogMap.get(key), expectedLogMap.get(key));
        }
    }

    @Step
    public void unselectCheckbox(DifElemEnum elem) {
        chexboxes.find(text(elem.text)).click();
        chexboxes.find(text(elem.text)).$("input").shouldNot(checked);
        expectedLogMap.put(elem.text, "false");
    }
}
