package nl.tibs.phasevoltagereader.infra;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
@Slf4j
public class TelegramMapper {
    private final static String L1_VOLTAGE_KEY = "1-0:32.7.0";
    private final static String L2_VOLTAGE_KEY = "1-0:52.7.0";
    private final static String L3_VOLTAGE_KEY = "1-0:72.7.0";

    public static Telegram mapTelegram(String input) {
        int phase1Voltage = getIntValue(input, L1_VOLTAGE_KEY);
        int phase2Voltage = getIntValue(input, L2_VOLTAGE_KEY);
        int phase3Voltage = getIntValue(input, L3_VOLTAGE_KEY);

        return new Telegram(phase1Voltage, phase2Voltage, phase3Voltage);
    }

    private static int getIntValue(String input, String key){
        int start = input.indexOf(key)+(key.length() + 1);
        int end = input.indexOf(".", start);

        return Integer.parseInt(input.substring(start, end));
    }
}
