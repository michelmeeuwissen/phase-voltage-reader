package nl.tibs.phasevoltagereader.infra;

import lombok.Value;

@Value
public class Telegram {
    int phaseL1Voltage;
    int phaseL2Voltage;
    int phaseL3Voltage;
}
