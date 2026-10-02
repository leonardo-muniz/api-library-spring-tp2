package com.library.loans_service.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.loans_service.dto.EmprestimoDTO;
import com.library.loans_service.models.Emprestimo;
import com.library.loans_service.services.EmprestimoService;

import feign.FeignException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService service;

    public EmprestimoController(EmprestimoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Emprestimo> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Emprestimo> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Emprestimo> criar(@Valid @RequestBody EmprestimoDTO request) {
        Emprestimo emprestimo = service.criar(request.idLivro(), request.quantidade());
        return ResponseEntity.status(201).body(emprestimo);
    }

    @ExceptionHandler(FeignException.NotFound.class)
    public ResponseEntity<Void> livroNaoEncontrado() {
        return ResponseEntity.notFound().build();
    }
}
