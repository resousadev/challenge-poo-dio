package io.resousadev.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import io.resousadev.domain.Mentoring;

@RequestMapping("/mentorings")
public class MentoringController {

    private final List<Mentoring> mentorings = new ArrayList<>();

    @GetMapping("/")
    public ResponseEntity<List<Mentoring>> getAllMentorings() {
        return ResponseEntity.ok(mentorings);
    }

    @PostMapping("/")
    public ResponseEntity<Mentoring> createMentoring(@RequestBody Mentoring mentoring) {
        mentorings.add(mentoring);
        return ResponseEntity.ok(mentoring);
    }

    @GetMapping("/example")
    public ResponseEntity<Mentoring> getExampleMentoring() {
        Mentoring example = Mentoring.builder()
                .title("Mentoria em Java")
                .description("Sessão de mentoria para desenvolvedores Java")
                .date(LocalDate.now())
                .build();

        return ResponseEntity.ok(example);
    }
}
