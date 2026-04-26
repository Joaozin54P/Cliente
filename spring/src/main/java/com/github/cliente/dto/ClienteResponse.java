package com.github.cliente.dto;

public record ClienteResponse(
        String id,
        String nome,
        String dtNascimento,
        String logradouro,
        String numero,
        String cidade,
        String estado
) {}
