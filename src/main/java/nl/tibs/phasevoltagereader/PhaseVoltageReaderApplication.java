package nl.tibs.phasevoltagereader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PhaseVoltageReaderApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhaseVoltageReaderApplication.class, args);
	}

}
