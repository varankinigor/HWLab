package hw4.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.DifElemEnum;
import lombok.SneakyThrows;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private List<SelenideElement> actualLog;

    private Map<String, String> expectedLog = new HashMap<>();

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
        expectedLog.put(elem.text, "true");
    }

    @Step
    public void selectRadio(DifElemEnum metal) {
        radios.find(text(metal.text)).click();
        radios.find(text(metal.text)).$("input").should(checked);
        expectedLog.put("metal", metal.text);
    }

    @Step
    public void selectDropdown(DifElemEnum color) {
        dropdown.selectOption(color.text);
        dropdown.shouldBe(text(color.text));
        expectedLog.put("Colors", color.text);
    }

    @SneakyThrows
    @Step
    public void checkLog(DifElemEnum value) {
        for (SelenideElement element : actualLog) {
            if (element.getText().substring(9).startsWith(value.text)) {
                Assert.assertTrue(element.getText().endsWith(expectedLog.get(value.text)));
                return;
            } else if (element.getText().endsWith(value.text)) {
                if (element.getText().substring(9).startsWith("Colors")) {
                    Assert.assertTrue(element.getText().endsWith(expectedLog.get("Colors")));
                    return;
                } else if (element.getText().substring(9).startsWith("metal")) {
                    Assert.assertTrue(element.getText().endsWith(expectedLog.get("metal")));
                    return;
                }
            }
        }
        throw new IOException("Log error");
    }

    @Step
    public void unselectCheckbox(DifElemEnum elem) {
        chexboxes.find(text(elem.text)).click();
        chexboxes.find(text(elem.text)).$("input").shouldNot(checked);
        expectedLog.put(elem.text, "false");
    }
}
