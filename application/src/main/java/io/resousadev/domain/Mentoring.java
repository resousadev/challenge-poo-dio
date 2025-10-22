package io.resousadev.domain;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Entidade que representa uma mentoria no sistema.
 * Estende Content para herdar propriedades básicas como título e descrição.
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true) // Inclui campos da superclasse na comparação de igualdade
@NoArgsConstructor
@AllArgsConstructor
public class Mentoring extends Content {

    /**
     * Bônus de experiência específico para mentorias.
     */
    private static final double MENTORING_BONUS_XP = 20d;

    /**
     * Data em que a mentoria será realizada.
     */
    private LocalDate date;

    @Override
    public double calculateXp() {
        return DEFAULT_XP + MENTORING_BONUS_XP;
    }
}
