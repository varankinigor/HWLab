package utils;

import com.codeborne.selenide.SelenideElement;
import enums.DifElemEnum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogWork {

    public static Map<String, String> prepareLog(List<SelenideElement> logList) {
        Map<String, String> logMap = new HashMap<>();
        for (SelenideElement log : logList) {
            for (DifElemEnum key : DifElemEnum.values()) {
                if (log.getText().substring(9).startsWith(key.text)) {
                    logMap.put(key.text, log.getText().substring(log.getText().lastIndexOf(" ") + 1));
                } else if (log.getText().endsWith(key.text)) {
                    logMap.put(log.getText().substring(9).substring(0, log.getText().indexOf(" ")), key.text);
                }
            }
        }
        return logMap;
    }
}
