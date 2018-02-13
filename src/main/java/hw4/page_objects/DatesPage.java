package hw4.page_objects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Selenide.actions;

public class DatesPage {
    @FindBy(css = ".ui-slider-handle")
    private List<SelenideElement> nodes;

    @Step
    public void setAndCheckSliders(int left, int right) {
        actions().dragAndDropBy(nodes.get(0), -1000, 0).build().perform();
        actions().dragAndDropBy(nodes.get(1), 1000, 0).build().perform();

        double scrollPanelLength = nodes.get(1).getLocation().getX() - nodes.get(0).getLocation().getX();
        double step = scrollPanelLength / 100;

        actions().dragAndDropBy(nodes.get(0), (int) (left * step - ((left > 0) ? 0.5 * step : step)), 0).build()
                .perform();
        actions().dragAndDropBy(nodes.get(1), (int) (-((100 - right) * step + step)), 0).build().perform();

        Assert.assertEquals(Integer.parseInt(nodes.get(0).getText()), left);
        Assert.assertEquals(Integer.parseInt(nodes.get(1).getText()), right);

//        double step = (double) $(".ui-slider-horizontal").getSize().width / 100;
//        if (!sliders.get(0).getText().equals("0")) {
//            actions().dragAndDropBy(sliders.get(0), -1000, 0).build().perform();
//        }
//        if (!sliders.get(1).getText().equals("0")) {
//            actions().dragAndDropBy(sliders.get(1), -1000, 0).build().perform();
//        }
//        if (rightPos != 0) {
//            actions().dragAndDropBy(sliders.get(1), (int) (Math.floor(step * rightPos)), 0).build().perform();
//        }
//        if (leftPos != 0) {
//            actions().dragAndDropBy(sliders.get(0), (int) (Math.floor(step * leftPos)), 0).build().perform();
//        }
//        sliders.get(0).should(Condition.text(leftPos.toString()));
//        sliders.get(1).should(Condition.text(rightPos.toString()));
    }
}
