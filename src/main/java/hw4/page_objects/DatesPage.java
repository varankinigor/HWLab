package hw4.page_objects;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {
    @FindBy(css = ".ui-slider-handle")
    private ElementsCollection sliders;

    @Step
    public void setAndCheckSliders(Integer leftPos, Integer rightPos) {
        double step = (double) $(".ui-slider-horizontal").getSize().width / 100;
        if (!sliders.get(0).getText().equals("0")) {
            actions().dragAndDropBy(sliders.get(0), -1000, 0).build().perform();
        }
        if (!sliders.get(1).getText().equals("0")) {
            actions().dragAndDropBy(sliders.get(1), -1000, 0).build().perform();
        }
        if (rightPos != 0) {
            actions().dragAndDropBy(sliders.get(1), (int) (step * rightPos), 0).build().perform();
        }
        if (leftPos != 0) {
            actions().dragAndDropBy(sliders.get(0), (int) (step * leftPos), 0).build().perform();
        }
        Assert.assertEquals(sliders.get(0).getText(), leftPos.toString());
        Assert.assertEquals(sliders.get(1).getText(), rightPos.toString());
    }
}
