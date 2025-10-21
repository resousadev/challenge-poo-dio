package io.resousadev.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidade que representa um curso no sistema.
 * Demonstra o uso do Lombok e conceitos de POO.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    private String title;
    private String description;
    private Integer workload;

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
