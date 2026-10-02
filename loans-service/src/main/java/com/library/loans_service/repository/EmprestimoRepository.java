package com.library.loans_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.loans_service.models.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {}
