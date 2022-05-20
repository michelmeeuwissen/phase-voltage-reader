package nl.tibs.phasevoltagereader.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.tibs.phasevoltagereader.controller.dto.VoltagesDto;
import nl.tibs.phasevoltagereader.entity.ReadingEntity;
import nl.tibs.phasevoltagereader.exception.CurrentVoltagesException;
import nl.tibs.phasevoltagereader.infra.Telegram;
import nl.tibs.phasevoltagereader.infra.TelegramGateway;
import nl.tibs.phasevoltagereader.repository.ReadingRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class PhaseReadingService {

    private final TelegramGateway telegramGateway;
    private final ReadingRepository readingRepository;

    public VoltagesDto listCurrentVoltages() {
        try {
            Telegram telegram = telegramGateway.getTelegram();
            persistTelegram(telegram);
            return new VoltagesDto(telegram.getPhaseL1Voltage(), telegram.getPhaseL2Voltage(), telegram.getPhaseL3Voltage());
        } catch (Exception e) {
            log.error("Error getting current voltages" , e);
            throw new CurrentVoltagesException(e);
        }
    }

    private void persistTelegram(Telegram telegram) {
        ReadingEntity readingEntity = new ReadingEntity();
        readingEntity.setL1Voltage(telegram.getPhaseL1Voltage());
        readingEntity.setL2Voltage(telegram.getPhaseL2Voltage());
        readingEntity.setL3Voltage(telegram.getPhaseL3Voltage());
        readingRepository.save(readingEntity);
    }

}

