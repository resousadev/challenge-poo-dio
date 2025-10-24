package io.resousadev.controller;

import io.resousadev.domain.Dev;
import io.resousadev.service.DevService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/devs")
public class DevController {
    private final DevService devService;

    @PostMapping
    public ResponseEntity<Dev> createDev(@RequestParam String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Dev name must be provided");
        }

        if (devService.devExists(name)) {
            throw new IllegalStateException("Dev already exists with name: " + name);
        }

        Dev dev = new Dev();
        dev.setName(name);
        devService.addDev(dev);

        return ResponseEntity.status(HttpStatus.CREATED).body(dev);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Dev> getDevByName(@PathVariable String name) {
        return devService.findDevByName(name)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Set<Dev>> getAllDevs() {
        return ResponseEntity.ok(devService.getAllDevs());
    }

    @PostMapping("/{name}/progress")
    public ResponseEntity<Void> progressDev(@PathVariable String name) {
        Dev dev = devService.findDevByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Dev not found: " + name));

        devService.progressDev(dev);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}/xp")
    public ResponseEntity<Double> getDevTotalXp(@PathVariable String name) {
        Dev dev = devService.findDevByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Dev not found: " + name));

        double totalXp = devService.calculateDevTotalXp(dev);
        return ResponseEntity.ok(totalXp);
    }
}

