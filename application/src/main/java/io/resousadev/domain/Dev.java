package io.resousadev.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Dev {
    private String name;
    private Set<Content> enrolledContents = new LinkedHashSet<>();
    private Set<Content> completedContents = new LinkedHashSet<>();

    public void enrollInBootcamp(Bootcamp bootcamp) {
        this.enrolledContents.addAll(bootcamp.getContents());
        bootcamp.getEnrolledDevs().add(this);
    }

    public void progress() {
        this.enrolledContents.stream()
            .findFirst()
            .ifPresentOrElse(content -> {
                this.completedContents.add(content);
                this.enrolledContents.remove(content);
            }, () -> {
                throw new IllegalStateException("You are not enrolled in any content!");
            });
    }

    public double calculateTotalXp() {
        return this.completedContents.stream()
                .mapToDouble(Content::calculateXp)
                .sum();
    }
}
