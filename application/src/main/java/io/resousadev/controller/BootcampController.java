package io.resousadev.controller;

import io.resousadev.domain.Bootcamp;
import io.resousadev.domain.Dev;
import io.resousadev.service.BootcampService;
import io.resousadev.service.DevService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/bootcamps")
public class BootcampController {
    private final BootcampService bootcampService;
    private final DevService devService;

    @PostMapping("/enroll")
    public void enrollDevInBootcamp(String devName, String bootcampName) {
        if (devName == null || devName.isEmpty() || bootcampName == null || bootcampName.isEmpty()) {
            throw new IllegalArgumentException("Dev name and bootcamp name must be provided");
        }

        // Busca o dev existente
        Dev dev = devService.findDevByName(devName)
                .orElseThrow(() -> new IllegalArgumentException("Dev not found: " + devName));

        // Busca o bootcamp
        Bootcamp bootcamp = bootcampService.findBootcampByName(bootcampName)
                .orElseThrow(() -> new IllegalArgumentException("Bootcamp not found: " + bootcampName));

        // Matricula o dev no bootcamp (lógica no DevService)
        devService.enrollDevInBootcamp(dev, bootcamp);
    }

    @PostMapping("/add")
    public ResponseEntity<Bootcamp> addBootcamp(@RequestBody Bootcamp bootcamp) {
        bootcampService.addBootcamp(bootcamp);
        return ResponseEntity.ok(bootcamp);
    }

    @GetMapping("/completed")
    public ResponseEntity<Set<Bootcamp>> getCompletedBootcampsByDev(@RequestParam String devName) {
        if (devName == null || devName.isEmpty()) {
            throw new IllegalArgumentException("Dev name must be provided");
        }

        Dev dev = devService.findDevByName(devName)
                .orElseThrow(() -> new IllegalArgumentException("Dev not found: " + devName));

        Set<Bootcamp> completedBootcamps = devService.getCompletedBootcamps(dev, bootcampService.getAllBootcamps());
        return ResponseEntity.ok(completedBootcamps);
    }
}
