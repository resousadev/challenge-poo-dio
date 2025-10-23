package io.resousadev.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
