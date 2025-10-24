package io.resousadev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Content { // TODO: Use sealed classes after to learn more about it
    protected static final double DEFAULT_XP = 10d;

    private String title;
    private String description;

    public abstract double calculateXp();
}
