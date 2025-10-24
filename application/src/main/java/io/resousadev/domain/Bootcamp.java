package io.resousadev.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
public class Bootcamp {
    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private Set<Dev> enrolledDevs = new HashSet<>();
    private Set<Content> contents = new LinkedHashSet<>();
}
