package io.resousadev.controller;

import io.resousadev.domain.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller REST para gerenciar cursos e informações da aplicação.
 */
@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello World! Aplicação Challenge POO DIO está rodando!");
    }

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("OK - Aplicação funcionando corretamente");
    } 
}
