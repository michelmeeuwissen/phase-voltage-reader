package nl.tibs.phasevoltagereader.infra;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.tibs.phasevoltagereader.exception.TelegramException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
@RequiredArgsConstructor
public class TelegramGateway {
    private final WebClient webClient = WebClient.create();

    @Value("${telegram.service.url}")
    private String url;

    public Telegram getTelegram() {
        return webClient.get()
                .uri(url)
                .accept(MediaType.TEXT_PLAIN)
                .retrieve()
                .onStatus(HttpStatus::isError, errorResponse -> errorResponse.bodyToMono(String.class)
                        .flatMap(error -> {
                            log.error("Telegram call to home wizard returned status code [{}], and error [{}]", errorResponse.statusCode(), error);
                            return Mono.error(new TelegramException("There was an error processing the telegram:" + error));
                        }))
                .bodyToMono(String.class)
                .map(TelegramMapper::mapTelegram)
                .block();
    }

}
