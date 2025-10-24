package io.resousadev.service;

import io.resousadev.domain.Bootcamp;
import io.resousadev.domain.Content;
import io.resousadev.domain.Dev;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class DevService {

    private final Set<Dev> devs = new HashSet<>();

    public void addDev(Dev dev) {
        devs.add(dev);
    }

    public Optional<Dev> findDevByName(String name) {
        return devs.stream()
                .filter(dev -> dev.getName().equals(name))
                .findFirst();
    }

    public Set<Dev> getAllDevs() {
        return new HashSet<>(devs);
    }

    public boolean devExists(String name) {
        return findDevByName(name).isPresent();
    }

    public void enrollDevInBootcamp(Dev dev, Bootcamp bootcamp) {
        if (isDevEnrolledInBootcamp(dev, bootcamp)) {
            throw new IllegalStateException("Dev is already enrolled in this bootcamp");
        }

        // Adiciona os conteúdos do bootcamp ao dev
        addContentsToDevEnrollment(dev, bootcamp.getContents());

        // Adiciona o dev à lista de inscritos do bootcamp
        bootcamp.getEnrolledDevs().add(dev);
    }

    public boolean isDevEnrolledInBootcamp(Dev dev, Bootcamp bootcamp) {
        return bootcamp.getEnrolledDevs().contains(dev);
    }

    public void addContentsToDevEnrollment(Dev dev, Set<Content> contents) {
        dev.getEnrolledContents().addAll(contents);
    }

    public void progressDev(Dev dev) {
        dev.getEnrolledContents().stream()
                .findFirst()
                .ifPresentOrElse(content -> {
                    dev.getCompletedContents().add(content);
                    dev.getEnrolledContents().remove(content);
                }, () -> {
                    throw new IllegalStateException("You are not enrolled in any content!");
                });
    }

    public double calculateDevTotalXp(Dev dev) {
        return dev.getCompletedContents().stream()
                .mapToDouble(Content::calculateXp)
                .sum();
    }

    public Set<Bootcamp> getCompletedBootcamps(Dev dev, Set<Bootcamp> allBootcamps) {
        Set<Bootcamp> completedBootcamps = new HashSet<>();

        for (Bootcamp bootcamp : allBootcamps) {
            // Verifica se o dev está matriculado no bootcamp
            if (bootcamp.getEnrolledDevs().contains(dev)) {
                // Verifica se todos os conteúdos do bootcamp foram completados
                boolean allContentsCompleted = bootcamp.getContents().stream()
                        .allMatch(content -> dev.getCompletedContents().contains(content));

                if (allContentsCompleted && !bootcamp.getContents().isEmpty()) {
                    completedBootcamps.add(bootcamp);
                }
            }
        }

        return completedBootcamps;
    }
}

