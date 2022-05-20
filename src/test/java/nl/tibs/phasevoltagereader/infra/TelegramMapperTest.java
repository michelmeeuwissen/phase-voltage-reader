package nl.tibs.phasevoltagereader.infra;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class TelegramMapperTest {
    @Test
    void mapTelegramHappyFlow() throws IOException {
        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:telegram_valid.txt");
        Reader reader = new InputStreamReader(resource.getInputStream());
        String file = FileCopyUtils.copyToString(reader);
        Telegram telegram = TelegramMapper.mapTelegram(file);
        assertEquals(telegram.getPhaseL1Voltage(), 229);
        assertEquals(telegram.getPhaseL2Voltage(), 235);
        assertEquals(telegram.getPhaseL3Voltage(), 227);
    }
}
