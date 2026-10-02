package com.library.books_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.books_service.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {}
