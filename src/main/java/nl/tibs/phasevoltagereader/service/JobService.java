package nl.tibs.phasevoltagereader.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.tibs.phasevoltagereader.controller.dto.VoltagesDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class JobService {
    private final PhaseReadingService phaseReadingService;

    @Scheduled(cron = "*/30 * 9-18 * * *")
    public void syncAanvragenWithCRM() {
        VoltagesDto voltagesDto = phaseReadingService.listCurrentVoltages();
        log.info("L1: " + voltagesDto.getL1() + " , L2: " + voltagesDto.getL2()+ " , L3: " + voltagesDto.getL3());
    }
}
