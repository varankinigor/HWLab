package hw4.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {
    @FindBy(css = ".ui-slider-handle")
    private List<SelenideElement> sliders;

    @Step
    public void setAndCheckSliders(Integer leftPos, Integer rightPos) {
        actions().dragAndDropBy(sliders.get(0), -1000, 0).build().perform();
        actions().dragAndDropBy(sliders.get(1), 1000, 0).build().perform();
        double step = (sliders.get(1).getLocation().getX() - sliders.get(0).getLocation().getX()) / 100.0;

        if (leftPos != 0) {
            actions().dragAndDropBy(sliders.get(0), (int) (leftPos * step - 0.5 * step), 0).build().perform();
        }
        if (rightPos != 100) {
            actions().dragAndDropBy(sliders.get(1), (int) ((-100 + rightPos) * step - step), 0).build().perform();
        }

        sliders.get(0).should(Condition.text(leftPos.toString()));
        sliders.get(1).should(Condition.text(rightPos.toString()));
    }
}
