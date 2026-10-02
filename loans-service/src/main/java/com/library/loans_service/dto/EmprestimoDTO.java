package com.library.loans_service.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record EmprestimoDTO(
        Long id,
        @NotNull(message = "idLivro é obrigatório") Long idLivro,
        @NotNull(message = "quantidade é obrigatória") @Min(value = 1, message = "quantidade deve ser maior que zero") Integer quantidade,
        java.math.BigDecimal valorLivro) {
}
