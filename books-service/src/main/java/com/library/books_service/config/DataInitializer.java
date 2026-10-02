package com.library.books_service.config;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.library.books_service.model.Livro;
import com.library.books_service.repository.LivroRepository;

/**
 * Popula o banco H2 em memória com produtos de teste assim que a aplicação sobe.
 */
@Component
public class DataInitializer implements CommandLineRunner {

    private final LivroRepository livroRepository;

    public DataInitializer(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    @Override
    public void run(String... args) {
        livroRepository.save(new Livro("Notebook", new BigDecimal("3500.00")));
        livroRepository.save(new Livro("Mouse sem fio", new BigDecimal("79.90")));
        livroRepository.save(new Livro("Teclado mecânico", new BigDecimal("299.90")));
        livroRepository.save(new Livro("Monitor 27 polegadas", new BigDecimal("1299.00")));
        livroRepository.save(new Livro("Webcam Full HD", new BigDecimal("199.90")));
        livroRepository.save(new Livro("Headset gamer", new BigDecimal("249.50")));
        livroRepository.save(new Livro("SSD 1TB", new BigDecimal("459.90")));
        livroRepository.save(new Livro("Cadeira de escritório", new BigDecimal("899.00")));
        livroRepository.save(new Livro("Carregador USB-C 65W", new BigDecimal("129.90")));
        livroRepository.save(new Livro("Smartphone", new BigDecimal("2199.00")));
    }
}
