package io.resousadev.service;

import io.resousadev.domain.Bootcamp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BootcampService {

    private final Set<Bootcamp> bootcamps = new HashSet<>();

    public Optional<Bootcamp> findBootcampByName(String name) {
        return bootcamps.stream()
                .filter(bootcamp -> bootcamp.getName().equals(name))
                .findFirst();
    }


    public void addBootcamp(Bootcamp bootcamp) {
        bootcamps.add(bootcamp);
    }

    public Set<Bootcamp> getAllBootcamps() {
        return new HashSet<>(bootcamps);
    }
}
