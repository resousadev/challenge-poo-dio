package io.resousadev.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
class Bootcamp {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<Dev> enrolledDevs = new HashSet<>();
    private Set<Content> contents = new LinkedHashSet<>();

    Bootcamp() {
        this.startDate = LocalDate.now();
        this.endDate = this.startDate.plusDays(45);
    }

    Bootcamp(String name, String description, Set<Dev> enrolledDevs, Set<Content> contents) {
        this.name = name;
        this.description = description;
        this.startDate = LocalDate.now();
        this.endDate = this.startDate.plusDays(45);
        this.enrolledDevs = enrolledDevs != null ? enrolledDevs : new HashSet<>();
        this.contents = contents != null ? contents : new LinkedHashSet<>();
    }
}
