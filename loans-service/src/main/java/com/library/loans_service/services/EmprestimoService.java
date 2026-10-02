package com.library.loans_service.services;

import org.springframework.stereotype.Service;

import com.library.loans_service.dto.LivroDTO;
import com.library.loans_service.interfaces.LivroClient;
import com.library.loans_service.models.Emprestimo;
import com.library.loans_service.repository.EmprestimoRepository;

@Service
public class EmprestimoService {
    
    private final EmprestimoRepository emprestimoRepository;
    private final LivroClient livroClient;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, LivroClient livroClient) {
        this.emprestimoRepository = emprestimoRepository;
        this.livroClient = livroClient;
    }

    public Emprestimo criar(Long livroId, int quantidade) {
        LivroDTO livro = livroClient.buscarPorId(livroId);

        if (livro == null) {
            throw new IllegalArgumentException("Livro não encontrado");
        }

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setIdLivro(livro.id());
        emprestimo.setQuantidade(quantidade);
        emprestimo.setValorLivro(livro.preco());

        return emprestimoRepository.save(emprestimo);
    }

    public java.util.List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public java.util.Optional<Emprestimo> buscarPorId(Long id) {
        return emprestimoRepository.findById(id);
    }
}
