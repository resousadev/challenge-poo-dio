package io.resousadev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Entidade que representa um curso no sistema.
 * Demonstra o uso do Lombok e conceitos de POO com herança de Content.
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true) // Inclui campos da superclasse na comparação de igualdade
@NoArgsConstructor
@AllArgsConstructor
public class Course extends Content {

    /**
     * Carga horária do curso em horas.
     */
    private Integer workload;

    @Override
    public double calculateXp() {
        return workload != null ? DEFAULT_XP * workload : 0.0;
    }

    /**
     * Calcula a duração em dias assumindo 8 horas de estudo por dia.
     * @return duração em dias
     */
    public double getDurationInDays() {
        if (workload == null) {
            return 0;
        }
        return workload / 8.0;
    }

    /**
     * Verifica se é um curso intensivo (mais de 40 horas).
     * @return true se for intensivo
     */
    public boolean isIntensive() {
        return workload != null && workload > 40;
    }
}
