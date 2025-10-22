package io.resousadev.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa um curso no sistema.
 * Demonstra o uso do Lombok e conceitos de POO.
 */
@Data
@EqualsAndHashCode(callSuper = true) // Inclui campos da superclasse na comparação de igualdade
@NoArgsConstructor
public class Course extends Content {

    private Integer workload;

    @Builder
    public Course(String title, String description, Integer workload) {
        super(title, description);
        this.workload = workload;
    }

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
