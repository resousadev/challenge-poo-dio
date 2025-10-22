package io.resousadev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Classe abstrata que representa um conteúdo no sistema.
 * Serve como base para cursos e mentorias, demonstrando herança e polimorfismo.
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Content {
    /**
     * Valor padrão de experiência (XP) para conteúdos.
     */
    protected static final double DEFAULT_XP = 10d;

    /**
     * Título do conteúdo.
     */
    private String title;
    
    /**
     * Descrição detalhada do conteúdo.
     */
    private String description;

    /**
     * Calcula a experiência (XP) que o conteúdo proporciona.
     * @return valor de XP calculado
     */
    public abstract double calculateXp();

}
