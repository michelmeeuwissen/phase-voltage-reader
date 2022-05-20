package nl.tibs.phasevoltagereader.controller;

import lombok.RequiredArgsConstructor;
import nl.tibs.phasevoltagereader.controller.dto.VoltagesDto;
import nl.tibs.phasevoltagereader.service.PhaseReadingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/phases")
public class PhaseController {

    private final PhaseReadingService phaseReadingService;

    @GetMapping("/current")
    public ResponseEntity<VoltagesDto> listCurrentVoltages() {
        return ResponseEntity.ok(phaseReadingService.listCurrentVoltages());
    }

}

