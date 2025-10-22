package io.resousadev.domain;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true) // Inclui campos da superclasse na comparação de igualdade
@NoArgsConstructor
public class Mentoring extends Content {

    private static final double MENTORING_BONUS_XP = 20d;

    private LocalDate date;

    @Builder
    public Mentoring(String title, String description, LocalDate date) {
        super(title, description);
        this.date = date;
    }

    @Override
    public double calculateXp() {
        return DEFAULT_XP + MENTORING_BONUS_XP;
    }
}
