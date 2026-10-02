package com.library.loans_service.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.library.loans_service.dto.LivroDTO;

@FeignClient(name = "books-service", path = "/livros")
public interface LivroClient {

    @GetMapping("/{id}")
    LivroDTO buscarPorId(@PathVariable("id") Long id);
}
