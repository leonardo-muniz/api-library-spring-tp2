package com.library.books_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.library.books_service.model.Livro;
import com.library.books_service.repository.LivroRepository;

/**
 * Regra de negócio de Livro. O controller não fala direto com o repository,
 * fala com este service.
 */
@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public List<Livro> listarTodos() {
        return livroRepository.findAll();
    }

    public Optional<Livro> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public Livro criar(Livro livro) {
        return livroRepository.save(livro);
    }
}
