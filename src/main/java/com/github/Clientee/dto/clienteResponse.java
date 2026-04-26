package com.github.Clientee.dto;


public record clienteResponse(
        String id,
        String nome,
        String dtNascimento,
        String logradouro,
        String numero,
        String cidade,
        String estado
) {}